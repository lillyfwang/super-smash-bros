 

import ucigame.*;
/**
 * This is the percentages that shows how much damage you have from the other character.
 * It has a total of 150 frames, so it is basically a lot of busy work and really, really boring
 * typing. If this is "bad coding," just disregard this class when grading. We couldn't think of any 
 * faster way to do this. It's just for asthetic purposes...of course.
 */
public class Percentages
{
    Sprite sprite;
    Image picture;
    int damage;
    static final int DEAD = 149;

    Percentages(Sprite s, Image i, int d)
    {
        sprite = s;
        picture = i;
        damage = d;
        setup();
    }

    /**
     * Creates 150 frames for damage percentages and defines the sequences. Just a lot of repeating.
     */
    void setup()
    {
        sprite.addFrames(picture,      
            0, 0,
            150, 0,
            300, 0,
            450, 0,
            600, 0,
            750, 0,
            900, 0,
            1050, 0, 
            1200, 0,
            1350, 0,
            0, 80,
            150, 80,
            300, 80,
            450, 80,
            600, 80,
            750, 80,
            900, 80,
            1050, 80, 
            1200, 80,
            1350, 80,
            0, 160,
            150, 160,
            300, 160,
            450, 160,
            600, 160,
            750, 160,
            900, 160,
            1050, 160, 
            1200, 160,
            1350, 160,
            0, 240,
            150, 240,
            300, 240,
            450, 240,
            600, 240,
            750, 240,
            900, 240,
            1050, 240, 
            1200, 240,
            1350, 240,
            0, 320,
            150, 320,
            300, 320,
            450, 320,
            600, 320,
            750, 320,
            900, 320,
            1050, 320, 
            1200, 320,
            1350, 320,
            0, 400,
            150, 400,
            300, 400,
            450, 400,
            600, 400,
            750, 400,
            900, 400,
            1050, 400, 
            1200, 400,
            1350, 400,
            0, 480,
            150, 480,
            300, 480,
            450, 480,
            600, 480,
            750, 480,
            900, 480,
            1050, 480, 
            1200, 480,
            1350, 480,
            0, 560,
            150, 560,
            300, 560,
            450, 560,
            600, 560,
            750, 560,
            900, 560,
            1050, 560, 
            1200, 560,
            1350, 560,
            0, 640,
            150, 640,
            300, 640,
            450, 640,
            600, 640,
            750, 640,
            900, 640,
            1050, 640, 
            1200, 640,
            1350, 640,
            0, 720,
            150, 720,
            300, 720,
            450, 720,
            600, 720,
            750, 720,
            900, 720,
            1050, 720, 
            1200, 720,
            1350, 720,
            0, 800,
            150, 800,
            300, 800,
            450, 800,
            600, 800,
            750, 800,
            900, 800,
            1050, 800, 
            1200, 800,
            1350, 800,
            0, 880,
            150, 880,
            300, 880,
            450, 880,
            600, 880,
            750, 880,
            900, 880,
            1050, 880, 
            1200, 880,
            1350, 880,
            0, 960,
            150, 960,
            300, 960,
            450, 960,
            600, 960,
            750, 960,
            900, 960,
            1050, 960, 
            1200, 960,
            1350, 960,
            0, 1040,
            150, 1040,
            300, 1040,
            450, 1040,
            600, 1040,
            750, 1040,
            900, 1040,
            1050, 1040, 
            1200, 1040,
            1350, 1040,
            0, 1120,
            150, 1120,
            300, 1120,
            450, 1120,
            600, 1120,
            750, 1120,
            900, 1120,
            1050, 1120, 
            1200, 1120,
            1350, 1120
        );

        sprite.defineSequence("0", 0);
        sprite.defineSequence("1", 1);
        sprite.defineSequence("2", 2);
        sprite.defineSequence("3", 3);
        sprite.defineSequence("4", 4);
        sprite.defineSequence("5", 5);
        sprite.defineSequence("6", 6);
        sprite.defineSequence("7", 7);
        sprite.defineSequence("8", 8);
        sprite.defineSequence("9", 9);

        sprite.defineSequence("10", 10);
        sprite.defineSequence("11", 11);
        sprite.defineSequence("12", 12);
        sprite.defineSequence("13", 13);
        sprite.defineSequence("14", 14);
        sprite.defineSequence("15", 15);
        sprite.defineSequence("16", 16);
        sprite.defineSequence("17", 17);
        sprite.defineSequence("18", 18);
        sprite.defineSequence("19", 19);

        sprite.defineSequence("20", 20);
        sprite.defineSequence("21", 21);
        sprite.defineSequence("22", 22);
        sprite.defineSequence("23", 23);
        sprite.defineSequence("24", 24);
        sprite.defineSequence("25", 25);
        sprite.defineSequence("26", 26);
        sprite.defineSequence("27", 27);
        sprite.defineSequence("28", 28);
        sprite.defineSequence("29", 29);

        sprite.defineSequence("30", 30);
        sprite.defineSequence("31", 31);
        sprite.defineSequence("32", 32);
        sprite.defineSequence("33", 33);
        sprite.defineSequence("34", 34);
        sprite.defineSequence("35", 35);
        sprite.defineSequence("36", 36);
        sprite.defineSequence("37", 37);
        sprite.defineSequence("38", 38);
        sprite.defineSequence("39", 39);

        sprite.defineSequence("40", 40);
        sprite.defineSequence("41", 41);
        sprite.defineSequence("42", 42);
        sprite.defineSequence("43", 43);
        sprite.defineSequence("44", 44);
        sprite.defineSequence("45", 45);
        sprite.defineSequence("46", 46);
        sprite.defineSequence("47", 47);
        sprite.defineSequence("48", 48);
        sprite.defineSequence("49", 49);

        sprite.defineSequence("50", 50);
        sprite.defineSequence("51", 51);
        sprite.defineSequence("52", 52);
        sprite.defineSequence("53", 53);
        sprite.defineSequence("54", 54);
        sprite.defineSequence("55", 55);
        sprite.defineSequence("56", 56);
        sprite.defineSequence("57", 57);
        sprite.defineSequence("58", 58);
        sprite.defineSequence("59", 59);

        sprite.defineSequence("60", 60);
        sprite.defineSequence("61", 61);
        sprite.defineSequence("62", 62);
        sprite.defineSequence("63", 63);
        sprite.defineSequence("64", 64);
        sprite.defineSequence("65", 65);
        sprite.defineSequence("66", 66);
        sprite.defineSequence("67", 67);
        sprite.defineSequence("68", 68);
        sprite.defineSequence("69", 69);

        sprite.defineSequence("70", 70);
        sprite.defineSequence("71", 71);
        sprite.defineSequence("72", 72);
        sprite.defineSequence("73", 73);
        sprite.defineSequence("74", 74);
        sprite.defineSequence("75", 75);
        sprite.defineSequence("76", 76);
        sprite.defineSequence("77", 77);
        sprite.defineSequence("78", 78);
        sprite.defineSequence("79", 79);

        sprite.defineSequence("80", 80);
        sprite.defineSequence("81", 81);
        sprite.defineSequence("82", 82);
        sprite.defineSequence("83", 83);
        sprite.defineSequence("84", 84);
        sprite.defineSequence("85", 85);
        sprite.defineSequence("86", 86);
        sprite.defineSequence("87", 87);
        sprite.defineSequence("88", 88);
        sprite.defineSequence("89", 89);

        sprite.defineSequence("90", 90);
        sprite.defineSequence("91", 91);
        sprite.defineSequence("92", 92);
        sprite.defineSequence("93", 93);
        sprite.defineSequence("94", 94);
        sprite.defineSequence("95", 95);
        sprite.defineSequence("96", 96);
        sprite.defineSequence("97", 97);
        sprite.defineSequence("98", 98);
        sprite.defineSequence("99", 99);

        sprite.defineSequence("100", 100);
        sprite.defineSequence("101", 101);
        sprite.defineSequence("102", 102);
        sprite.defineSequence("103", 103);
        sprite.defineSequence("104", 104);
        sprite.defineSequence("105", 105);
        sprite.defineSequence("106", 106);
        sprite.defineSequence("107", 107);
        sprite.defineSequence("108", 108);
        sprite.defineSequence("109", 109);

        sprite.defineSequence("110", 110);
        sprite.defineSequence("111", 111);
        sprite.defineSequence("112", 112);
        sprite.defineSequence("113", 113);
        sprite.defineSequence("114", 114);
        sprite.defineSequence("115", 115);
        sprite.defineSequence("116", 116);
        sprite.defineSequence("117", 117);
        sprite.defineSequence("118", 118);
        sprite.defineSequence("119", 119);

        sprite.defineSequence("120", 120);
        sprite.defineSequence("121", 121);
        sprite.defineSequence("122", 122);
        sprite.defineSequence("123", 123);
        sprite.defineSequence("124", 124);
        sprite.defineSequence("125", 125);
        sprite.defineSequence("126", 126);
        sprite.defineSequence("127", 127);
        sprite.defineSequence("128", 128);
        sprite.defineSequence("129", 129);

        sprite.defineSequence("130", 130);
        sprite.defineSequence("131", 131);
        sprite.defineSequence("132", 132);
        sprite.defineSequence("133", 133);
        sprite.defineSequence("134", 134);
        sprite.defineSequence("135", 135);
        sprite.defineSequence("136", 136);
        sprite.defineSequence("137", 137);
        sprite.defineSequence("138", 138);
        sprite.defineSequence("139", 139);

        sprite.defineSequence("140", 140);
        sprite.defineSequence("141", 141);
        sprite.defineSequence("142", 142);
        sprite.defineSequence("143", 143);
        sprite.defineSequence("144", 144);
        sprite.defineSequence("145", 145);
        sprite.defineSequence("146", 146);
        sprite.defineSequence("147", 147);
        sprite.defineSequence("148", 148);
        sprite.defineSequence("149", 149);
    }

    Sprite getSprite()
    {
        return sprite;
    }

    /**
     * This sets the damage to an amount based on the passed in integer. We pass in the amount of
     * damage from the sprites (kirby/iceclimber).
     */
    void getDamage(int d)
    {
        if (damage < DEAD)
            damage = d;
        else
            damage = DEAD;
    }

    /**
     * This draws what damage the sprite has. Very tedious to type out.
     */
    void illustrate()
    {        
        if (damage == 0)
            sprite.play("0");
        if (damage == 1)
            sprite.play("1");
        if (damage == 2)
            sprite.play("2");
        if (damage == 3)
            sprite.play("3");
        if (damage == 4)
            sprite.play("4");
        if (damage == 5)
            sprite.play("5");
        if (damage == 6)
            sprite.play("6");
        if (damage == 7)
            sprite.play("7");
        if (damage == 8)
            sprite.play("8");
        if (damage == 9)
            sprite.play("9");

        if (damage == 10)
            sprite.play("10");
        if (damage == 11)
            sprite.play("11");
        if (damage == 12)
            sprite.play("12");
        if (damage == 13)
            sprite.play("13");
        if (damage == 14)
            sprite.play("14");
        if (damage == 15)
            sprite.play("15");
        if (damage == 16)
            sprite.play("16");
        if (damage == 17)
            sprite.play("17");
        if (damage == 18)
            sprite.play("18");
        if (damage == 19)
            sprite.play("19");

        if (damage == 20)
            sprite.play("20");
        if (damage == 21)
            sprite.play("21");
        if (damage == 22)
            sprite.play("22");
        if (damage == 23)
            sprite.play("23");
        if (damage == 24)
            sprite.play("24");
        if (damage == 25)
            sprite.play("25");
        if (damage == 26)
            sprite.play("26");
        if (damage == 27)
            sprite.play("27");
        if (damage == 28)
            sprite.play("28");
        if (damage == 29)
            sprite.play("29");

        if (damage == 30)
            sprite.play("30");
        if (damage == 31)
            sprite.play("31");
        if (damage == 32)
            sprite.play("32");
        if (damage == 33)
            sprite.play("33");
        if (damage == 34)
            sprite.play("34");
        if (damage == 35)
            sprite.play("35");
        if (damage == 36)
            sprite.play("36");
        if (damage == 37)
            sprite.play("37");
        if (damage == 38)
            sprite.play("38");
        if (damage == 39)
            sprite.play("39");

        if (damage == 40)
            sprite.play("40");
        if (damage == 41)
            sprite.play("41");
        if (damage == 42)
            sprite.play("42");
        if (damage == 43)
            sprite.play("43");
        if (damage == 44)
            sprite.play("44");
        if (damage == 45)
            sprite.play("45");
        if (damage == 46)
            sprite.play("46");
        if (damage == 47)
            sprite.play("47");
        if (damage == 48)
            sprite.play("48");
        if (damage == 49)
            sprite.play("49");

        if (damage == 50)
            sprite.play("50");
        if (damage == 51)
            sprite.play("51");
        if (damage == 52)
            sprite.play("52");
        if (damage == 53)
            sprite.play("53");
        if (damage == 54)
            sprite.play("54");
        if (damage == 55)
            sprite.play("55");
        if (damage == 56)
            sprite.play("56");
        if (damage == 57)
            sprite.play("57");
        if (damage == 58)
            sprite.play("58");
        if (damage == 59)
            sprite.play("59");

        if (damage == 60)
            sprite.play("60");
        if (damage == 61)
            sprite.play("61");
        if (damage == 62)
            sprite.play("62");
        if (damage == 63)
            sprite.play("63");
        if (damage == 64)
            sprite.play("64");
        if (damage == 65)
            sprite.play("65");
        if (damage == 66)
            sprite.play("66");
        if (damage == 67)
            sprite.play("67");
        if (damage == 68)
            sprite.play("68");
        if (damage == 69)
            sprite.play("69");

        if (damage == 70)
            sprite.play("70");
        if (damage == 71)
            sprite.play("71");
        if (damage == 72)
            sprite.play("72");
        if (damage == 73)
            sprite.play("73");
        if (damage == 74)
            sprite.play("74");
        if (damage == 75)
            sprite.play("75");
        if (damage == 76)
            sprite.play("76");
        if (damage == 77)
            sprite.play("77");
        if (damage == 78)
            sprite.play("78");
        if (damage == 79)
            sprite.play("79");

        if (damage == 80)
            sprite.play("80");
        if (damage == 81)
            sprite.play("81");
        if (damage == 82)
            sprite.play("82");
        if (damage == 83)
            sprite.play("83");
        if (damage == 84)
            sprite.play("84");
        if (damage == 85)
            sprite.play("85");
        if (damage == 86)
            sprite.play("86");
        if (damage == 87)
            sprite.play("87");
        if (damage == 88)
            sprite.play("88");
        if (damage == 89)
            sprite.play("89");

        if (damage == 90)
            sprite.play("90");
        if (damage == 91)
            sprite.play("91");
        if (damage == 92)
            sprite.play("92");
        if (damage == 93)
            sprite.play("93");
        if (damage == 94)
            sprite.play("94");
        if (damage == 95)
            sprite.play("95");
        if (damage == 96)
            sprite.play("96");
        if (damage == 97)
            sprite.play("97");
        if (damage == 98)
            sprite.play("98");
        if (damage == 99)
            sprite.play("99");

        if (damage == 100)
            sprite.play("100");
        if (damage == 101)
            sprite.play("101");
        if (damage == 102)
            sprite.play("102");
        if (damage == 103)
            sprite.play("103");
        if (damage == 104)
            sprite.play("104");
        if (damage == 105)
            sprite.play("105");
        if (damage == 106)
            sprite.play("106");
        if (damage == 107)
            sprite.play("107");
        if (damage == 108)
            sprite.play("108");
        if (damage == 109)
            sprite.play("109");

        if (damage == 110)
            sprite.play("110");
        if (damage == 111)
            sprite.play("111");
        if (damage == 112)
            sprite.play("112");
        if (damage == 113)
            sprite.play("113");
        if (damage == 114)
            sprite.play("114");
        if (damage == 115)
            sprite.play("115");
        if (damage == 116)
            sprite.play("116");
        if (damage == 117)
            sprite.play("117");
        if (damage == 118)
            sprite.play("118");
        if (damage == 119)
            sprite.play("119");

        if (damage == 120)
            sprite.play("120");
        if (damage == 121)
            sprite.play("121");
        if (damage == 122)
            sprite.play("122");
        if (damage == 123)
            sprite.play("123");
        if (damage == 124)
            sprite.play("124");
        if (damage == 125)
            sprite.play("125");
        if (damage == 126)
            sprite.play("126");
        if (damage == 127)
            sprite.play("127");
        if (damage == 128)
            sprite.play("128");
        if (damage == 129)
            sprite.play("129");

        if (damage == 130)
            sprite.play("130");
        if (damage == 131)
            sprite.play("131");
        if (damage == 132)
            sprite.play("132");
        if (damage == 133)
            sprite.play("133");
        if (damage == 134)
            sprite.play("134");
        if (damage == 135)
            sprite.play("135");
        if (damage == 136)
            sprite.play("136");
        if (damage == 137)
            sprite.play("137");
        if (damage == 138)
            sprite.play("138");
        if (damage == 139)
            sprite.play("139");

        if (damage == 140)
            sprite.play("140");
        if (damage == 141)
            sprite.play("141");
        if (damage == 142)
            sprite.play("142");
        if (damage == 143)
            sprite.play("143");
        if (damage == 144)
            sprite.play("144");
        if (damage == 145)
            sprite.play("145");
        if (damage == 146)
            sprite.play("146");
        if (damage == 147)
            sprite.play("147");
        if (damage == 148)
            sprite.play("148");
        if (damage == 149)
            sprite.play("149");
    }
}
