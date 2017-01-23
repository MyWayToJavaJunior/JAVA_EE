package ru.sstu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.sstu.model.SurveyForm;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Shvarts on 16.01.2017.
 */
@Controller
@RequestMapping("/validation")
public class ValidationController {

    @RequestMapping(value = "/survey", method = RequestMethod.GET)
    public String form1(ModelMap modelMap)
    {
        modelMap.addAttribute("surveyForm", new SurveyForm());
        return "surveyForm";
    }

    @RequestMapping(value = "/survey", method = RequestMethod.POST)
    public String form1(@Valid @ModelAttribute("surveyForm") SurveyForm sform, BindingResult result, ModelMap modelMap)
    {
        if(result.hasErrors()) {
            System.out.println("ERROR");
            return "surveyForm";
        }
        else {
            System.out.println("CORRECT");
            return "surveyFormResult";
        }
    }


    /*
     * Примеры регулярных выражений
     */
    @RequestMapping(value = {"","/"})
    @ResponseBody
    public String index()
    {
        String s = "1\nCurrently only 2bb6 JVM 5 is supported (\"publicly\"). Major release versions of J, along with their release dates:\n" +
                "\n" +
                "  \t JDK 10 (January 21., 1996)\n" +
                "JDK 11 rth(1February 19, 1997)\n" +
                "J2SE 12 (December 01., 1998)\n" +
                "J2SE 13 (May 39, 2000)\n" +
                "J2SE 14 (February 6, 2006)\n" +
                "    J2SE 5.0 (September 30, 2004)1\n" +
                "    Java SE 6 (December 11, 26b6)\n" +
                "    Java SE 7 (July 28, 2013)1\n" +
                "    Java SE 82  6 (March 18, 2014)";
        System.out.println(s);

        Matcher m;
        Pattern p;

        /*p = Pattern.compile(s);
        m = p.matcher(s);
        System.out.println(m.find());
        System.out.println(m.matches());
        System.out.println(s.contains(s));*/

        //метасимволы
        /*printAll(s, "1.");// . - любой символ

        printAll(s, "1\\.");// 1\. ищет единицу и точку

        printAll(s, "2..6");

        printAll(s, "2\\d\\d6"); // \d - цифровой символ


        printAll(s, "2\\D\\D6"); // \D - НЕцифровой символ

        printAll(s, "J\\w\\w\\w");// \w - буквы, цифры и _

        printAll(s, "J\\W\\W\\W"); // \W - НЕ (буквы, цифры и _)

        printAll(s, ",\\s"); // \s - пробельный символ

        printAll(s, ",\\S"); // \S - НЕпробельный символ
        */



        //перечни
        /*printAll(s, "[34567]"); // [] - один из перечня
        printAll(s, "[3-7]");
        printAll(s, "[0-47-9]");
        printAll(s, "[a-zA-Z]");
        printAll(s, "[a-fA-F0-9]");
        printAll(s, "[^a-fA-F0-9]");
        printAll("efefefgwg w435io ef90oo 900lo", "[a-z]\\d\\d\\d[a-z][a-z]");
        */

        //квантификация
  /*      printAll("hellooooo hello helloo hell heloooo", "hello+"); // + повторение один или более

        printAll("hellooooo hello helloo hell heloooo", "hello?"); // ? повторение один или ноль раз

        printAll("hellooooo hello helloo hell heloooo", "hello*"); // * повторение ноль или более раз

        printAll("efefefgwg w435io ef90oo 900lo", "[a-z]\\d{3}[a-z]{2}"); // {N} - повторение строго N раз


        printAll("efefefgwg 12345678998765400990 w435io ef90oo 900lo", "\\d{16}"); // номер кредитки

        printAll("1ef4efefgwg 12345678998765400990 w435io ef90oo 900lo", "\\d{2,4}"); // {M,N} - от M до N повторений включительно

        printAll("1ef4efefgwg 12345678998765400990 w435io ef90oo 900lo", "\\d{2,}"); // {M,} - от M повторений включительно

        printAll("1ef4efefgwg 12345678998765400990 w435io ef90oo 900lo", "\\d{,4}"); // {,N} - до N повторений включительно //FIXME
        //

*/

        //группировки
        /*printAll(" abababab aba abb bab abab !!!!ababab!! aabb", "(ab){2,3}");

        printAll(" 8a7b 0q1y7u8 abab 8ab6b aba abb bab", "(\\d[a-z]){2,3}");

        printAll("Yandex is the best company, Google is the worst, Facebook is medium", "Yandex|Google|Facebook");// | один из

        printAll("google.ru google.com mortal combat", "google\\.ru|com");
        printAll("google.ru google.com mortal combat", "google\\.(ru|com)");*/

        //конец и начало строк
        /*printAll("hellooooo hello", "hello{2,5}$"); // $ - конец строки

        printAll(".jpegabcdef.jpeg", "\\.jpe?g$"); // $ - конец строки
        printAll("abcdef.jpeg.exe", "\\.jpe?g$"); // $ - конец строки


        printAll("https://ya.ru https://efkje", "^https?://"); // ^ - начало строки

        printAll("9999999999999999", "^\\d{16}$"); // $ - конец строки
*/

        /*printAll("(asasad(Moth)er (wash(es r)a(ma) a)sassadfe)", "\\(.+\\)");


        p = Pattern.compile("[yY]andex");
        m = p.matcher("Yandex is the best company yandex");
        System.out.println(m.replaceAll("***"));

        p = Pattern.compile("[yY]andex");
        m = p.matcher("Yandex is the best company yandex");
        System.out.println(m.replaceAll(""));


        p = Pattern.compile("[яЯ]ндекс");
        m = p.matcher("Яндекс лучше всех, яндекс ждёт успех");
        System.out.println(m.replaceAll(""));

        p = Pattern.compile("[а-яА-ЯёЁ]+");
        m = p.matcher("Яндекс лучше 1335 (№%(№%*?, яндекс ждЁт успех йЪъь");
        System.out.println(m.replaceAll(""));

        p = Pattern.compile("\\w+");
        m = p.matcher("Google Яндекс лучше 1335 (№%(№%*?, я_$$$ндекс ждЁт успех йЪъь");
        System.out.println(m.replaceAll(""));

        p = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
        m = p.matcher("Google Яндекс лучше 1335 (№%(№%*?, я_$$$ндекс ждЁт успех йЪъь");
        System.out.println(m.replaceAll(""));*/
        /*
*/

        //примеры

        System.out.println("\n=====Разбиение предложения на слова:");

        String s2 = "Londo'n is a capital of Great,      Britain... is not it?";
        System.out.println("исходная строка: " + s2);
        p = Pattern.compile("[^a-zA-Z'\\-]+");
        String[] splittedWords = p.split(s2);
        for(String word : splittedWords)
        {
            System.out.println(word);
        }

        //30 31
        //2[0-9]
        //1[0-9]
        //[1-9]
        System.out.println("========================");
        System.out.println(s);
        p = Pattern.compile("(\\(([A-Z][a-z]+) (3[01]|[12][0-9]|[1-9]), ([12]\\d{3})\\))");
        m = p.matcher(s);
        while(m.find())
        {
            System.out.println("Всё совпавшее:" + m.group());
            System.out.println("Первая группа:" + m.group(1));
            System.out.println("Month:" + m.group(2));
            System.out.println("Day:" + m.group(3));
            System.out.println("Year:" + m.group(4));
        }

        System.out.println("========================");
        System.out.println("ФИО");


        s = "Иванов Иван Иванович";
        p = Pattern.compile("^(([A-ЯЁ][а-яё]+ ){2}([A-ЯЁ][а-яё]+))$");
        m = p.matcher(s);
        while(m.find())
        {
            System.out.println("Всё совпавшее:" + m.group());
            System.out.println("Первая группа:" + m.group(1));
            System.out.println("Имя:" + m.group(2));
            System.out.println("Фамилия:" + m.group(2));
            System.out.println("Отчество:" + m.group(3));
        }

        return "validation";
    }

    private void printAll(String source, String regEx)
    {
        System.out.println("=================================================");
        System.out.println("Сама строка: " + source);
        System.out.println("Регулярное выражение:" + regEx);

        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx);
        m = p.matcher(source);
        while(m.find())
        {
            System.out.println("Совпавшее:" + m.group());
        }
    }
}
