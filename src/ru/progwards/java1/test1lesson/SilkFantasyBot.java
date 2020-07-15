package ru.progwards.java1.test1lesson;

import org.telegram.telegrambots.ApiContextInitializer;
import ru.progwards.java1.testlesson.ProgwardsTelegramBot;

public class SilkFantasyBot extends ProgwardsTelegramBot {
    private final String menu = "У нас вы можете приобрести азербайджанские шелковые келагаи (платки), дингя (маленькие косынки) и шарфы https://silkfantasy.az/";

    @Override
    public String processMessage(String text) {
        checkTags(text);
        if (foundCount() == 1) {
            if (checkLastFound("привет"))
                return "Здравствуйте! Добро пожаловать в онлайн магазин азербайджанских шелковых келагаи - Silk Fantasy!\n Чем можем Вам помочь?";

            if (checkLastFound("товар"))
                return "Весь ассортимент Вы можете посмотреть на нашем сайте https://silkfantasy.az/.\n Актуальный товар помечен меткой \"В наличии\"";

            if (checkLastFound("прайс"))
                return "Стоимость баскальских келагаи 60 манат, шекинских келагаи 50 манат и 70 манат, баскальских шарфов 40 манат, косынок 30 манат\n Более подробно с ценами вы можете ознакомиться на сайте, сменив тип валюты";

            if (checkLastFound("доставка"))
                return "Да, у нас есть доставка. Мы пользуемся услугами курьерской службы. По городу: в метро на платформе 3 маната, адресная доставка 5 манат.";

            if (checkLastFound("где купить"))
                return "Приобрести келагаи Вы можете оформив заказ через сайт - выбрав тип доставки от самовывоза до почтовой отправки; приехав и выбрав лично. + Оставьте, пожалуйста, адрес и контакты для связи для выполнения заказа";

            if (checkLastFound("посылка"))
                return "Да, мы отсылаем за рубеж. Стоимость зависит от страны отправления, веса посылки";

            if (checkLastFound("контакты"))
                return "Контакты для связи +99450-370-04-23. Наш сайт https://silkfantasy.az/";

            if (checkLastFound("выставки"))
                return "Да, мы иногда принимаем участие в различных выставках. Вы можете подойти и сделать свой выбор там. И просто хорошо провести время. Информация о выставках на сайте всегда актуальна.";

            if (checkLastFound("конец"))
                return "Спасибо за внимание";

            if (checkLastFound("дурак"))
                return "Не надо ругаться. Я не волшебник, я только учусь";
            return "Если вы ищете конкретный цвет или модель, рекомендую искать на сайте. Интересует что-то еще?" + getLastFound();
        }
        if (foundCount() > 1)
            return "Вы искали это?: \n" + extract() + "Выберите из предложенных вариантов и наберите мне сообщением, чтобы получить информацию";
        return "Я всего лишь робот и не обладаю этой информацией. Попробуйте связаться по номеру указанному в контактах или переформулируйте свой вопрос.";
    }

    public static void main(String[] args) {
        System.out.println("Hello, Silk Fantasy!");
        ApiContextInitializer.init();

        SilkFantasyBot bot = new SilkFantasyBot();
        bot.username = "SilkFantasyBot";
        bot.token = "1369077907:AAEcalSvjMZQ32F_2d60zA3UpCYzKOLEgv0";

        bot.addTags("привет", "привет, здрасьте, здравствуй, добр, день, вечер, утро, hi, hello, salam");
        bot.addTags("конец", "спасибо, до свидания, до встречи, увидимся");
        bot.addTags("дурак", "дурак, придурок, идиот, тупой");

        bot.addTags("Келагаи", "келагаи, шелк, плат, больш, 160х160, 150х150, Баскал, Шеки");
        bot.addTags("Шарф с кистями", "шарф, кист, бахром, шелк, 160х80, Баскал");
        bot.addTags("Дингя-косынка", "дингя, косынк, маленьк, детск, шелк, 80х80, Баскал");

        bot.addTags("цвет", "цвет, красный, красная, синий, синяя, голубой, голубая, бирюзовый, бирюзовая, черный, черная, белый, белая, зеленый, зеленая, серый, серая, розовый, розовая, оранжевый, оранжевая, желтый, желтая");

        bot.addTags("товар", "ассортимент, цвета, выбор, выбр, посмотреть, можно посмотреть, в наличии");
        bot.addTags("прайс", "прайс, цен, сколько стоит, сколько стоит келагаи, сколько стоит дингя, сколько стоит шарф");
        bot.addTags("доставка", "доставка, доставляете, доставка есть, доставку");

        bot.addTags("где купить", "купить, приобрести, заказать, в реале");
        bot.addTags("посылка", "отсылаете, посылка, почта, за рубеж, стран");
        bot.addTags("контакты", "контакты, номер, связаться, связи, whatsapp, вацап, ватсап, сайт");

        bot.addTags("выставки", "выставк, учавствуете, дата, место");

        bot.addTags("заказ принят", "заказ, дом, метро, ул., курьер");

        bot.start();
    }
}
