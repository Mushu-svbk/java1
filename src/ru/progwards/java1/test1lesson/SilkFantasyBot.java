package ru.progwards.java1.test1lesson;

import org.telegram.telegrambots.ApiContextInitializer;
import ru.progwards.java1.testlesson.ProgwardsTelegramBot;

public class SilkFantasyBot extends ProgwardsTelegramBot {
    private final String menu = "У нас вы можете приобрести азербайджанские шелковые келагаи (платки), дингя (маленькие комынки) и шарфы";

    @Override
    public String processMessage(String text) {
        checkTags(text);
        if (foundCount() == 1) {
            if (checkLastFound("привет"))
                return "Здравствуйте! Добро пожаловать в онлайн магазин азербайджанских шелковых келагаи - Silk Fantasy!\n Чем можем Вам помочь?" + menu;
            if (checkLastFound("ассортимент"))
                return "Весь ассортимент Вы можете посмотреть на нашем сайте https://silkfantasy.az/.\n Актуальный товар помечен меткой \"В наличии\"";
            if (checkLastFound("конец"))
                return "Спасибо за заказ.";
            if (checkLastFound("дурак"))
                return "Не надо ругаться. Я не волшебник, я только учусь";
            return "Отлично, добавляю в заказ " + getLastFound() + " Желаете что-то еще?" + "Оставьте, пожалуйста, адрес и контакты для связи";
        }
        if (foundCount() > 1)
            return "Под Ваш запрос подходит: \n" + extract() + "Выбирайте что Вам нравится, и я добавлю это в заказ.";
        return "Возможно у нас этого нет, попробуйте сказать по другому. " + menu;
    }

    public static void main(String[] args) {
        System.out.println("Hello, Silk Fantasy!");
        ApiContextInitializer.init();

        SilkFantasyBot bot = new SilkFantasyBot();
        bot.username = "SilkFantasyBot";
        bot.token = "1369077907:AAEcalSvjMZQ32F_2d60zA3UpCYzKOLEgv0";

        bot.addTags("привет", "привет, здрасьте, здравствуй, добр, день, вечер, утро, hi, hello, salam");
        bot.addTags("конец", "конец, все, стоп, нет");
        bot.addTags("дурак", "дурак, придурок, идиот, тупой");

        bot.addTags("Келагаи", "келагаи, шелк, плат, больш, 160х160, 150х150, Баскал, Шеки");
        bot.addTags("Шарф с кистями", "шарф, кист, бахром, шелк, 160х80, Баскал");
        bot.addTags("Дингя-косынка", "дингя, косынк, маленьк, детск, шелк, 80х80, Баскал");

        bot.addTags("ассортимент", "ассортимент, выбор, выбр, посмотреть, можно посмотреть, в наличии, есть");
        bot.addTags("Торт медовик", "десерт, мед, бисквит");
        bot.addTags("Эклеры", "десерт, заварной, крем, тесто");

        bot.addTags("Кола", "напит, пить, кола");
        bot.addTags("Холодный чай", "напит, пить, чай, липтон, лимон");
        bot.addTags("Сок", "напит, пить, сок, апельсиноый, яблочный, вишневый");

        bot.start();
    }
}
