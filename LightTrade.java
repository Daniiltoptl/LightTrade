package LightStudio.lightTrade;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.ChatColor;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.ClickEvent;

import java.util.HashMap;
import java.util.UUID;

public class LightTrade extends JavaPlugin {
    private final HashMap<UUID, UUID> tradeRequests = new HashMap<>();
    private final HashMap<UUID, Inventory> activeTrades = new HashMap<>();
    private FileConfiguration config;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        config = this.getConfig();
        this.getCommand("trade").setExecutor(this::onTradeCommand);
    }

    // Обработчик команды "/trade"
    public boolean onTradeCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by players.");
            return true;
        }
        Player player = (Player) sender;

        // Проверка на пермишн для отправки трейда
        if (args.length == 1 && args[0].equalsIgnoreCase("accept") && !player.hasPermission("safetrade.accept")) {
            player.sendMessage(ChatColor.RED + "You do not have permission to accept trade requests.");
            return true;
        }

        // Проверка на пермишн для отклонения трейда
        if (args.length == 1 && args[0].equalsIgnoreCase("reject") && !player.hasPermission("safetrade.reject")) {
            player.sendMessage(ChatColor.RED + "You do not have permission to reject trade requests.");
            return true;
        }

        // Проверка на пермишн для отправки запроса
        if (args.length == 1 && !player.hasPermission("safetrade.send")) {
            player.sendMessage(ChatColor.RED + "You do not have permission to send trade requests.");
            return true;
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("accept")) {
            acceptTrade(player);
            return true;
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null || target == player) {
                player.sendMessage(getMessage("trade-no-request"));
                return true;
            }
            sendTradeRequest(player, target);
            return true;
        }
        player.sendMessage("Usage: /trade <player> or /trade accept");
        return true;
    }

    // Отправка запроса на обмен
    private void sendTradeRequest(Player sender, Player receiver) {
        tradeRequests.put(receiver.getUniqueId(), sender.getUniqueId());
        sender.sendMessage(getMessage("trade-request-sent").replace("{player}", receiver.getName()));
        receiver.sendMessage(getMessage("trade-request-received").replace("{player}", sender.getName()));

        // Отправка кликабельных сообщений
        //Создаем текст с кликабельными ссылками
        TextComponent acceptMessage = new TextComponent(getMessage("trade-clickable-accept"));
        acceptMessage.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/trade accept"));
        receiver.spigot().sendMessage(acceptMessage);

        TextComponent rejectMessage = new TextComponent(getMessage("trade-clickable-reject"));
        rejectMessage.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/trade reject"));
        receiver.spigot().sendMessage(rejectMessage);

    }

    // Принятие запроса на обмен
    private void acceptTrade(Player receiver) {
        UUID senderUUID = tradeRequests.get(receiver.getUniqueId());
        if (senderUUID == null) {
            receiver.sendMessage(getMessage("trade-no-request"));
            return;
        }
        Player sender = Bukkit.getPlayer(senderUUID);
        if (sender == null) {
            receiver.sendMessage("Trade partner is no longer online.");
            return;
        }
        tradeRequests.remove(receiver.getUniqueId());
        openTradeGUI(sender, receiver);
    }

    // Открытие интерфейса обмена
    private void openTradeGUI(Player sender, Player receiver) {
        String title = getMessage("trade.gui-title").replace("{player}", sender.getName());
        Inventory tradeInventory = Bukkit.createInventory(null, 27, ChatColor.translateAlternateColorCodes('&', title));

        // Создание рамки с цветом из конфигурации
        ItemStack border = createItem(Material.WHITE_STAINED_GLASS_PANE, " ", getMessage("gui.border-color"));
        for (int i = 0; i < 9; i++) {
            tradeInventory.setItem(i, border);
            tradeInventory.setItem(18 + i, border);
        }
        tradeInventory.setItem(9, border);
        tradeInventory.setItem(17, border);

        // Место для предметов
        tradeInventory.setItem(getConfig().getInt("trade.item-slot"), new ItemStack(Material.CHEST));

        // Место для валюты (если Vault включен)
        if (getConfig().getBoolean("trade.currency")) {
            tradeInventory.setItem(getConfig().getInt("trade.money-slot"), new ItemStack(Material.GOLD_INGOT));
        }

        // Кнопки подтверждения и отмены
        tradeInventory.setItem(22, createItem(Material.EMERALD_BLOCK, getMessage("gui.accept-button"), getConfig().getString("gui.accept-color")));
        tradeInventory.setItem(24, createItem(Material.REDSTONE_BLOCK, getMessage("gui.cancel-button"), getConfig().getString("gui.cancel-color")));

        sender.openInventory(tradeInventory);
        receiver.openInventory(tradeInventory);

        activeTrades.put(sender.getUniqueId(), tradeInventory);
        activeTrades.put(receiver.getUniqueId(), tradeInventory);
    }

    // Создание предметов для интерфейса
    private ItemStack createItem(Material material, String name, String colorCode) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.valueOf(colorCode) + name);
            item.setItemMeta(meta);
        }
        return item;
    }

    // Получение сообщения из конфигурации
    private String getMessage(String path) {
        return config.getString("messages." + path, "Message not found");
    }
}
