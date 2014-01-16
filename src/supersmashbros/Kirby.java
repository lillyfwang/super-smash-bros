package supersmashbros;

import ucigame.*;

public class Kirby extends SSChar
{

    Kirby(Sprite s, Image i, int ii, int iii, boolean b)
    {
        super(s, i, ii, iii, b);
        setup();
    }

    void setup()
    {
        sprite.addFrames(picture,      
            0, 0,
            100, 0,
            200, 0,
            300, 0,
            0, 100,
            100, 100,
            200, 100,
            300, 100,
            400, 100,
            500, 100,
            600, 100,
            700, 100,
            0, 700,
            100, 700,
            200, 700,
            300, 700,
            0, 400,
            100, 400,
            200, 400,
            300, 400,
            400, 400,
            500, 400,
            600, 400,
            700, 400,
            800, 400,
            900, 400,
            1000, 400,
            100, 500, 
            200, 500,
            300, 500,
            400, 500,
            0, 600,
            100, 600, 
            200, 600,
            300, 600,
            400, 600,
            0, 300,
            100, 300,
            200, 300
        );

        sprite.defineSequence("Stand", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3);
        sprite.defineSequence("Run", 4, 5, 6, 7, 8, 9, 10, 11);
        sprite.defineSequence("Fly", 12, 13, 14);
        sprite.defineSequence("Fall", 15); 
        sprite.defineSequence("Hammer", 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26);
        sprite.defineSequence("Punch", 27, 28, 29, 30);
        sprite.defineSequence("Crouch", 31);
        sprite.defineSequence("Crouch Attack", 31, 32, 33, 34, 35);
        sprite.defineSequence("SuckIn", 36, 37);
        sprite.defineSequence("Weight", 38);

        sprite.play("Stand");
    }

    /**
     * This plays the sequence of whatever kirby will do when each key is pressed
     */
    void keyPressed(String str)
    {   
        if(!charCollided)
            sprite.defineSequence("Stand", 15);
        else 
            sprite.defineSequence("Stand", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3);

        if(str.equals("UPandLEFT"))
        {
            charY = charY - 10;
            charX = charX - 5;
            charHeadedRight = false;
            sprite.play("Fly");
        }
        else if(str.equals("UPandRIGHT"))
        {
            charY = charY - 10;
            charX = charX + 5;
            charHeadedRight = true;
            sprite.play("Fly");
        }
        else if(str.equals("UP"))
        {
            charY = charY - 10;
            sprite.play("Fly");
        }
        else if(str.equals("RIGHT"))
        {
            charX = charX + 5;
            charHeadedRight = true;
            if(!charCollided)
            {
                sprite.play("Fall");
            }
            else 
            {
                sprite.play("Run");
            }
        }
        else if(str.equals("LEFT"))
        {
            charX = charX - 5;
            charHeadedRight = false;
            if(!charCollided)
                sprite.play("Fall");
            else 
                sprite.play("Run");
        }
        else if(str.equals("DOWN"))
        {
            if(!charCollided)
                {
                    sprite.play("Weight");
                    charY = charY + 10;
                }
            else 
                sprite.play("Crouch");
        }
        else if(str.equals("COMMA"))
        {
            if(charCollided)    
                sprite.play("Punch");
        }
        else if(str.equals("PERIODandLEFT"))
        {
            if(charCollided)
            {
                charHeadedRight = false;
                sprite.play("Hammer");
            }
        }
        else if(str.equals("PERIODandRIGHT"))
        {
            if(charCollided)
            {
                charHeadedRight = true;
                sprite.play("Hammer");
            }
        }
        else if(str.equals("PERIODandDOWN"))
        {
            if(charCollided)
                sprite.play("Crouch Attack");
        }
        else if(str.equals("PERIOD"))
        {
            if(charCollided)
                sprite.play("SuckIn");
        }
    }
}

