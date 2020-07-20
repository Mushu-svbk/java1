package ru.progwards.java1.test1lesson;

import org.telegram.telegrambots.ApiContextInitializer;
import ru.progwards.java1.testlesson.ProgwardsTelegramBot;

public class SilkFantasyBot extends ProgwardsTelegramBot {
    private final String menu = "У нас вы можете приобрести азербайджанские шелковые келагаи (платки), дингя (маленькие косынки) и шарфы https://silkfantasy.az/";
    private final String menuaz = "Siz bizdən Azərbaycan ipək kəlağayıları (yaylıqları), dingələr (kiçik ləçəklər) və şərflər ala bilərsiniz https://silkfantasy.az/az/";
    private final String menuen = "You may acquire from us Azerbaijani silk kelagayies (head covers), dingas (little kerchiefs) and scarfs https://silkfantasy.az/en/";

    @Override
    public String processMessage(String text) {
        checkTags(text);
        if (foundCount() == 1) {
            if (checkLastFound("привет"))
                return "Здравствуйте! Добро пожаловать в онлайн магазин азербайджанских шелковых келагаи - Silk Fantasy!\n Чем можем Вам помочь? " + menu;

                else if (checkLastFound("salam"))
                    return "Salam! Azərbaycan ipək kəlağayıların onlayn-mağazasına - Silk Fantasy dükanına xoş gəlmişsiniz!\n Sizə necə kömək edə bilərik? " + menuaz;

                else if (checkLastFound("hello"))
                    return "Good day! Welcome to Silk Fantasy – an online shop of the Azerbaijani silk kelagayies!\n How we could help you? " + menuen;

            if (checkLastFound("товар"))
                return "Весь ассортимент Вы можете посмотреть на нашем сайте https://silkfantasy.az/.\n Актуальный товар помечен меткой \"В наличии\"";

            else if (checkLastFound("mal"))
                return "Bütün çeşidlərimizlə https://silkfantasy.az/ saytımızda tanış ola bilərsiniz.\n Aktual mallar \"Hazırda var\" işarəsi ilə nişanlanıb";

            else if (checkLastFound("goods"))
                return "You may see all assortment in our website https://silkfantasy.az/.\n The actual goods are marked as \"Exists\"";

            if (checkLastFound("Келагаи"))
                return "Келагаи Баскальского или Шекинского производства. Натуральный шелк. Размер 150х150 или 160х160. https://silkfantasy.az/katalog/kelagai";

                else if (checkLastFound("Kəlağayı"))
                    return "Basqal və ya Şəki istehsalı olan kəlağayılar. Təbii ipək. Ölçüsü: 150x150 və ya 160x160. https://silkfantasy.az/az/katalog/kelagai";

                else if (checkLastFound("Kelagayi"))
                    return "Kelagayies made in Basqal or Sheki. Natural silk. Size 150x150 or 160x160. https://silkfantasy.az/en/katalog/kelagai";

            if (checkLastFound("Шарф с кистями"))
                return "Шарф Баскальского производства. С кистями, натуральный шелк. Размер 160х80. https://silkfantasy.az/katalog/sharfi";

                else if (checkLastFound("Saçaqlı şərf"))
                    return "Basqal istehsalı olan şərf. Saçaqlı, təbii ipək. Ölçüsü: 160x80. https://silkfantasy.az/az/katalog/sharfi";

                else if (checkLastFound("Scarf with fringes"))
                    return "Scarf with fringes made in Basqal. Natural silk. Size 160x80. https://silkfantasy.az/en/katalog/sharfi";

            if (checkLastFound("Дингя-косынка"))
                return "Дингя Баскальского производства. Натуральный шелк. Размер 80х80. https://silkfantasy.az/katalog/dinge-lecek";

                else if (checkLastFound("Dingə-ləçək"))
                    return "Basqal istehsalı olan dingə. Təbii ipək. Ölçüsü: 80x80. https://silkfantasy.az/az/katalog/dinge-lecek";

                else if (checkLastFound("Dinga-kerchief"))
                    return "Dinga made in Basqal. Natural silk. Size 80x80. https://silkfantasy.az/en/katalog/dinge-lecek";

            if (checkLastFound("прайс"))
                return "Стоимость баскальских келагаи 60 манат, шекинских келагаи 50 манат и 70 манат, баскальских шарфов 40 манат, косынок 30 манат\n Более подробно с ценами вы можете ознакомиться на сайте, сменив тип валюты";

                else if (checkLastFound("qiymət"))
                    return "Basqal kəlağayılarının qiyməti 60 manat, Şəki kəlağayılarının qiyməti 50 manat və 70 manat, Basqal şərflərinin qiyməti 40 manat, ləçəklərin qiyməti 30 manatdır\n Valyuta növünü dəyişməklə saytda qiymətlərlə tanış ola bilərsiniz";

                else if (checkLastFound("price"))
                    return "The price of Basqal kelagayies is AZN 60, the price of Sheki kelagayies is AZN 50 and AZN 70, the price of Basqal scarfs is AZN 40 and the price of kerchiefs is AZN 30 \n You may be acquainted with the prices in details in the website changing the currency type";

            if (checkLastFound("доставка"))
                return "Да, у нас есть доставка. Мы пользуемся услугами курьерской службы. По городу: в метро на платформе 3 маната, адресная доставка 5 манат.";

                else if (checkLastFound("çatdırılma"))
                    return "Bəli, biz çatdırma edirik. Biz kuryer xidmətlərindən istifadə edirik. Şəhər daxilində: metronun platformasında – 3 manat, ünvanlı çatdırma – 5 manat.";

                else if (checkLastFound("delivery"))
                    return "Yes, we have delivery. We use the courier services. In the city: on an underground platform – AZN 3, addressed delivery – AZN 5.";

            if (checkLastFound("где купить"))
                return "Приобрести келагаи Вы можете оформив заказ через сайт - выбрав тип доставки от самовывоза до почтовой отправки; приехав и выбрав лично. + Оставьте, пожалуйста, адрес и контакты для связи для выполнения заказа";

                else if (checkLastFound("haradan almaq"))
                    return "Kəlağayını əldə etmək üçün saytda sifarişi rəsmiləşdirə bilərsiniz. Bu zaman sifarişi həm şəxsən götürmək, həm də poçtla göndərmək mümkündür; .şəxsən gəlib seçə bilərsiniz. + Zəhmət olmasa, sifarişin icrası üçün ünvanı və əlaqə nömrələrini göstərin";

                else if (checkLastFound("where to buy"))
                    return "You may acquire kelagayi making order via website – choosing the type of delivery from self-taking up to sending via post; coming and choosing personally. + Be so kind to leave the address and contacts or implementing the order";

            if (checkLastFound("посылка"))
                return "Да, мы отсылаем за рубеж. Стоимость зависит от страны отправления, веса посылки";

                else if (checkLastFound("bağlama"))
                    return "Bəli, biz xaricə göndəririk. Qiymət göndərilən ölkədən və bağlamanın çəkisindən asılıdır";

                else if (checkLastFound("baggage"))
                    return "Yes, we send abroad. The price depends on the country of sending and the weight of the baggage";

            if (checkLastFound("контакты"))
                return "Контакты для связи +99450-370-04-23. Наш сайт https://silkfantasy.az/";

                else if (checkLastFound("əlaqə"))
                    return "Əlaqə nömrələri +99450-370-04-23. Saytımız https://silkfantasy.az/";

                else if (checkLastFound("contacts"))
                    return "Contact number +99450-370-04-23. Our website https://silkfantasy.az/";

            if (checkLastFound("выставки"))
                return "Да, мы иногда принимаем участие в различных выставках в городе Баку. Вы можете подойти и сделать свой выбор там. И просто хорошо провести время. Информация о выставках на сайте всегда актуальна.";

                else if (checkLastFound("sərgilər"))
                    return "Bəli, biz bəzən Bakı şəhərində keçirilən müxtəlif sərgilərdə iştirak edirik. Yaxınlaşıb orada da seçim edə bilərsiniz. Sərgilərdə maraqlı vaxt keçirmək də mümkündür. Saytda sərgilər haqqında məlumatlar daim aktualdır.";

                else if (checkLastFound("exhibitions"))
                    return "Yes, sometimes we participate at various exhibitions held in Baku city. You may come and choose there and, spend an interesting time. The information about exhibitions in the website is always actual.";

            if (checkLastFound("конец"))
                return "Спасибо за внимание";

                else if (checkLastFound("son"))
                    return "Diqqətinizə görə təşəkkür";

                else if (checkLastFound("end"))
                    return "Thanks for attention";

            if (checkLastFound("дурак"))
                return "Не надо ругаться. Я не волшебник, я только учусь";

                else if (checkLastFound("axmaq"))
                    return "Söyüş söymək lazım deyil. Mən sehrbaz deyiləm, yenicə öyrənirəm";

                else if (checkLastFound("fool"))
                    return "Don’t swear. I’m not a magician but only study";

            return "Если вы ищете конкретный цвет или модель, рекомендую искать на сайте. Интересует что-то еще? Əgər Siz komnkret rəng və ya model axtarırsınızsa, saytda axtarmağınızı tövsiyə edirəm. Daha nə iləsə maraqlanırsınızmı? If you are looking for a concrete color or model I recommend to search in the website. Anything interesting else?" + getLastFound();
        }
        if (foundCount() >1)
            return "Вы искали это?: \n" + extract() + "Выберите из предложенных вариантов и наберите мне сообщением, чтобы получить информацию.\n Siz bunu axtarırdınız?: \n" + extract() + "Təklif olunan variantlar arasından seçim edib məlumat almaq üçün mənimlə əlaqə yaradın.\n Did you look for it?: \n" + extract() + "Choose among the offered options and contact me for information ";
        return "Я всего лишь робот и не обладаю этой информацией. Попробуйте связаться по номеру указанному в контактах или переформулируйте свой вопрос.\n Mən, sadəcə, robotam və bu barədə məlumatlı deyiləm. Göstərilən əlaqə nömrəsi ilə əlaqə saxlayın, yaxud sualınızı başqa cür verin.\n I am only a robot and don’t have this information. Try to call the number shown in contacts or reformulate your question ";
    }

    public static void main(String[] args) {
        System.out.println("Hello, Silk Fantasy!");
        ApiContextInitializer.init();

        SilkFantasyBot bot = new SilkFantasyBot();
        bot.username = "SilkFantasyBot";
        bot.token = "1369077907:AAEcalSvjMZQ32F_2d60zA3UpCYzKOLEgv0";

        bot.addTags("привет", "привет, здрасьте, здравствуй, добр, день, вечер, утро, privet");
        bot.addTags("salam", "salam, slm, hər vaxtınız, axşamınız, sabahınız, xeyir, xoş gördük");
        bot.addTags("hello", "hi, good, day, evening, morning, how do you do, hello");

        bot.addTags("конец", "спасибо, до свидания, до встречи, увидимся");
        bot.addTags("son", "çox sağ olun, cox sag, salamat qalın, görüşənədək, görüşərik");
        bot.addTags("end", "thanks, thanx, good bye, see, later ");

        bot.addTags("дурак", "дурак, придурок, идиот, тупой");
        bot.addTags("axmaq", "axmaq, səfeh, gic, kütbeyin");
        bot.addTags("fool", "fool, stupid, idiot, donkey");


        bot.addTags("Келагаи", "келагаи, шелк, плат, больш, 160х160, 150х150, Баскал, Шеки");
        bot.addTags("Kəlağayı", "kəlağayı, ipək, yaylıq, yaylıqlar, böyük 160х160, 150х150, Basqal, Şəki");
        bot.addTags("Kelagayi", "kelagayi, silk, kerchief, kerchiefs, big, 160х160, 150х150, Basqal, Sheki");

        bot.addTags("Шарф с кистями", "шарф, кист, бахром, шелк, 160х80, Баскал");
        bot.addTags("Saçaqlı şərf", "şərf, saçaq, saç, ipək, 160х80, Basqal");
        bot.addTags("Scarf with fringes", "scarf, brush, fringe, silk, 160х80, Basqal");

        bot.addTags("Дингя-косынка", "дингя, косынк, маленьк, детск, шелк, 80х80, Баскал");
        bot.addTags("Dingə-ləçək", "dingə, ləçək, kiçik, uşaq, ipək, 80х80, Basqal");
        bot.addTags("Dinga-kerchief", "dinga, kerchief, small, child, silk, 80х80, Basqal");

        bot.addTags("цвет", "цвет, красный, красная, синий, синяя, голубой, голубая, бирюзовый, бирюзовая, черный, черная, белый, белая, зеленый, зеленая, серый, серая, розовый, розовая, оранжевый, оранжевая, желтый, желтая");
        bot.addTags("rəng", "rəng, qırmızı, göy, mavi, firuzəyi, qara, ağ, yaşıl, boz, çəhrayı, narıncı, sarı");
        bot.addTags("color", "color, red, blue, sky-blue, turquoise, black, white, green, grey, pink, orange, yellow");

        bot.addTags("товар", "ассортимент, цвета, выбор, выбр, посмотреть, можно посмотреть, в наличии");
        bot.addTags("mal", "çeşid, rənglər, seçim, seçmək,rengler, secim, secmek,baxmaq, baxmaq olar, hazırda var");
        bot.addTags("goods", "assortment, colors, option, choose, look, may look, exist");

        bot.addTags("прайс", "прайс, цен, сколько стоит");
        bot.addTags("qiymət", "qiymət, qiymet, dəyər, deyer, neçəyədir, neceyedir");
        bot.addTags("price", "price, cost, how much");

        bot.addTags("доставка", "доставка, доставляете, доставка есть, доставку");
        bot.addTags("çatdırılma", "tədarük, çatdırırsınızmı, çatdırılma, catdirilma, çatdırma, catdirma");
        bot.addTags("deivery", "delivery, do you deliver, we deliver");

        bot.addTags("где купить", "купить, приобрести, заказать, в реале");
        bot.addTags("haradan almaq", "almaq, əldə etmək, sifariş etmək, reallıqda");
        bot.addTags("where to buy", "buy, acquire, order, in real");

        bot.addTags("посылкаeng", "отсылаете, посылка, почта, за рубеж, стран");
        bot.addTags("bağlama", "göndərin, bağlama, poçt, xarici, ölkə");
        bot.addTags("baggage", "send, post, abroad, foreign, country");


        bot.addTags("контакты", "контакты, номер, связаться, связи, whatsupp, вацап, ватсап, сайт");
        bot.addTags("əlaqə", "əlaqə, nömrə, elaqe, nomre, yaratmaq, whatcapp, vaçap, vatsap, sayt");
        bot.addTags("contacts", "contacts, number, contact, call, whatsapp, website, site");

        bot.addTags("выставки", "выставк, учавствуете, дата, место");
        bot.addTags("sərgi", "sərgi, iştirak, tarix, yar");
        bot.addTags("exhibition", "exhibition, participate, date, place");

        bot.addTags("заказ принят", "заказ, дом, метро, ул., курьер");
        bot.addTags("sifariş qəbul olunub", "sifariş, ev, metro, küçə, kuryer");
        bot.addTags("order is accepted", "order, house, underground, street, courier");

        bot.start();
    }
}
