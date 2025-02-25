# LightTrade
LightTrade

LightTrade is a fully customizable plugin for secure item and currency trading in Minecraft.

LightTrade is a powerful and high-performance plugin designed to facilitate safe trades between players on your Minecraft server. With this plugin, your server will become a secure place for trading, allowing players to exchange items and currency without the risk of fraud. LightTrade is perfect for servers where economy and trading play a vital role, helping minimize potential conflicts or misunderstandings between players.

Key Features:

Trade Requests: Players can send trade requests to other players using simple commands. The plugin makes it easy to initiate trade deals between any players on the server.

Accepting and Rejecting Requests: After receiving a request, players can accept or decline it using the /trade accept or /trade reject commands. This ensures that accidental or unwanted trades are avoided, requiring explicit consent from both parties.

Trade Interface: When a trade request is accepted, a convenient and customizable interface opens with visual buttons for item placement. The interface lets players see exactly what they are about to trade and decide whether to proceed with the deal. The interface includes special slots for items and currency, which can be customized via the plugin's configuration file. It also has buttons for confirming or canceling the trade.

Trade Security: LightTrade ensures full trade security by ensuring both players agree to the terms before any items or currency are exchanged. The plugin prevents trade fraud, building trust between players.

Currency Support: The plugin integrates with the popular Vault plugin, enabling the use of currency in trades. You can set up various items, such as gold or other currencies, as part of the exchange. This allows economy-driven servers, such as roleplay servers, to integrate currency into the item trading process.

Full Customization: All messages, notifications, and interface elements can be customized in the configuration file. This lets you tailor the plugin to fit your server's style, using the desired colors, text, and item slots. You can also configure security and economy system settings.

Permission System: The plugin comes with a built-in permission system that allows administrators to control who can send, accept, or reject trade requests. This makes it possible to finely tune access to trading features for different groups of players, including administrators, moderators, and regular users.

Multi-Language Support: LightTrade supports multilingual configurations, making it easy to adapt the plugin for different languages. Each message in the plugin can be localized for your community, making it ideal for servers with an international audience.

How LightTrade Works:

Trade Request:
A player sends the /trade <player> command to initiate a trade with another player. If the target is another player, they will receive a trade request notification.

Accept or Decline:
The recipient of the request can use the /trade accept command to accept the request or /trade reject to decline it.

Opening the Interface:
When the trade request is accepted, a visual interface opens where players can place items for trade. The interface includes buttons for confirming or canceling the trade.

Completing the Trade:
Once both players place their items and confirm the trade, the transaction is completed. Items are exchanged between the players, and the trade is recorded.

Configuration and Customization:

Messages:
All messages the plugin sends to players can be configured. You can modify notification texts, error messages, and hints.

Interface:
Item slots, border colors, buttons, and other interface elements can be customized in the configuration file.

Currency Settings:
The plugin allows you to configure the currency players can use in trades, as well as set special slots for currency.

Example Configuration:

yaml
Копировать
Редактировать
LightTrade Configuration
messages:
  trade-request-sent: "You have sent a trade request to {player}."
  trade-request-received: "You have received a trade request from {player}."
  trade-no-request: "You have no pending trade requests."
  trade-clickable-accept: "Click to accept the trade request."
  trade-clickable-reject: "Click to reject the trade request."
  trade.gui-title: "Trade with {player}"
  gui.accept-button: "Accept Trade"
  gui.cancel-button: "Cancel Trade"
trade:
  item-slot: 11
  money-slot: 15
  currency: true
permissions:
  lighttrade.send
  lighttrade.accept
  lighttrade.reject
Permission System:

lighttrade.send: Allows sending trade requests.
lighttrade.accept: Allows accepting trade requests.
lighttrade.reject: Allows rejecting trade requests.
Advantages:

Security: Protects players from fraud during trades.
Ease of Use: All commands are easy to use, and the trade process is intuitive.
Flexibility and Customization: Easily adapts to any server needs, whether it’s a roleplay server or an economy-driven one.
Compatibility: Works with popular economy plugins like Vault and is compatible with Minecraft 1.12 and above.
Conclusion:

LightTrade is the perfect tool for Minecraft servers that want to provide their players with a secure and convenient way to trade items and currency. With its ease of use, powerful customization options, and security features, LightTrade will build trust between players and help create a fair trading environment on your server.

Requirements:

Minecraft 1.12 and above.
Vault (for currency use). Supports most economy plugins and permission management plugins.
LightTrade is not just a trading plugin—it's a secure and flexible tool that will become an integral part of your Minecraft server world!






































LightTrade — Полностью настраиваемый плагин для безопасного обмена предметами и валютой в Minecraft

LightTrade — это мощный и высокоэффективный плагин для Minecraft, предназначенный для организации безопасных обменов между игроками. С этим плагином ваш сервер станет безопасным местом для торговли, где игроки смогут обмениваться предметами и валютой без риска мошенничества. LightTrade идеально подходит для серверов, где экономика и обмен играют важную роль, и помогает минимизировать потенциальные конфликты или недоразумения между игроками.

Основные функции:
Запросы на обмен:

Игроки могут отправлять запросы на обмен другим игрокам с помощью простых команд.
Плагин позволяет легко инициировать торговые сделки между любыми игроками на сервере.
Принятие и отклонение запросов:

После получения запроса, игроки могут подтвердить или отклонить его с помощью команд /trade accept или /trade reject.
Это помогает избежать случайных или нежелательных сделок, требуя явного согласия обеих сторон.
Интерфейс обмена:

Когда запрос на обмен принят, открывается удобный и настраиваемый интерфейс с визуальными кнопками для размещения предметов.
Интерфейс позволяет игрокам видеть, что именно они собираются обменивать, и принять решение о сделке.
В интерфейсе предусмотрены специальные слоты для предметов и валюты, которые можно настроить через конфигурационный файл плагина.
В интерфейсе также предусмотрены кнопки для подтверждения и отмены сделки.
Безопасность обмена:

LightTrade обеспечивает полную безопасность сделок, гарантируя, что оба игрока согласны на условия обмена перед тем, как предметы или валюта будут переданы.
Плагин предотвращает мошенничество с обменами, тем самым повышая доверие между игроками.
Поддержка валюты:

Плагин интегрируется с популярным плагином Vault, что позволяет использовать валюту в обменах.
Вы можете настроить использование различных предметов, таких как золото или другие валюты, как часть обмена.
Это дает возможность серверам сэкономической направленности, например, ролевым серверам, интегрировать валюту в процесс обмена предметами.
Полная кастомизация:

Все сообщения, уведомления и элементы интерфейса можно настроить в конфигурационном файле.
Это позволяет адаптировать плагин под стиль вашего сервера, используя нужные цвета, текст и слоты для предметов.
В конфигурационном файле можно также настраивать параметры безопасности и экономической системы.
Пермишн-система:

Плагин имеет встроенную систему прав доступа, которая позволяет администраторам контролировать, кто может отправлять, принимать или отклонять запросы на обмен.
Это позволяет точно настроить доступность торговых функций для разных групп игроков, включая администраторов, модераторов и обычных пользователей.
Поддержка нескольких языков:

LightTrade поддерживает многоязычные конфигурации, что позволяет легко адаптировать плагин под различные языки.
Каждое сообщение в плагине можно локализовать для нужд вашего сообщества, что идеально подходит для серверов с международной аудиторией.
Как работает LightTrade:
Запрос на обмен: Игрок отправляет команду /trade <игрок>, чтобы инициировать обмен с другим игроком. Если цель запроса — это другой игрок, то он получает уведомление о запросе на обмен.

Подтверждение или отклонение: Получатель запроса может использовать команду /trade accept для принятия запроса или /trade reject для его отклонения.

Открытие интерфейса: Когда запрос на обмен принят, открывается визуальный интерфейс, в котором игроки могут разместить предметы для обмена. На интерфейсе есть кнопки для подтверждения или отмены обмена.

Завершение обмена: После того как оба игрока разместят свои предметы и подтвердят обмен, сделка будет завершена. Предметы будут переданы между игроками, а обмен будет зафиксирован.

Конфигурация и кастомизация:
Сообщения: Все сообщения, которые плагин отправляет игрокам, можно настроить. Вы можете изменить текст уведомлений, ошибок и подсказок.
Интерфейс: Слоты для предметов, цвет рамок, кнопки и другие элементы интерфейса могут быть настроены в конфигурационном файле.
Валютные настройки: Плагин позволяет настроить валюту, которую игроки могут использовать для обмена, а также устанавливать специальные слоты для валюты.
Пример конфигурации:
yaml
Копировать
Редактировать
# LightTrade Configuration

messages:
 trade-request-sent: "You have sent a trade request to {player}."

 trade-request-received: "You have received a trade request from {player}."
  
  trade-no-request: "You have no pending trade requests."
  
  trade-clickable-accept: "Click to accept the trade request."
 
  trade-clickable-reject: "Click to reject the trade request."
  
  trade.gui-title: "Trade with {player}"
  
  gui.accept-button: "Accept Trade"
 
  gui.cancel-button: "Cancel Trade"


trade:
 
  item-slot: 11
  
  money-slot: 15
 
  currency: true


permissions:
 
  - lighttrade.send
 
  - lighttrade.accept
 
  - lighttrade.reject

Пермишн-система:

lighttrade.send: Позволяет отправлять запросы на обмен.

lighttrade.accept: Позволяет принимать запросы на обмен.

lighttrade.reject: Позволяет отклонять запросы на обмен.

Преимущества:

Безопасность: Защищает игроков от мошенничества в процессе обмена.

Легкость использования: Все команды просты в использовании, и процесс обмена интуитивно понятен.

Гибкость и кастомизация: Легко адаптируется под любые нужды сервера, будь то ролевой сервер или сервер с экономикой.

Совместимость: Плагин работает с популярными плагинами для экономики, такими как Vault, и совместим с Minecraft 1.12 и выше.


Заключение:


LightTrade — это идеальный инструмент для серверов Minecraft, которые хотят предоставить своим игрокам безопасный и удобный способ обмена предметами и валютой. Благодаря простоте использования, мощной кастомизации и системе безопасности, LightTrade обеспечит высокий уровень доверия между игроками и поможет создать честную торговую среду на вашем сервере.


Требования:

Minecraft 1.12 и выше.

Vault (для использования валюты).
Поддержка большинства экономических плагинов и плагинов для управления правами доступа.

LightTrade — это не просто плагин для обмена, это безопасный и гибкий инструмент, который станет неотъемлемой частью вашего серверного мира Minecraft!
