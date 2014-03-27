
import ucigame.*;

public class IceClimbers extends SSChar
{

    IceClimbers(Sprite s, Image i, int ii, int iii, boolean b)
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
            250, 0,
            0, 100,
            100, 100,
            300, 100,
            400, 100,
            500, 100,
            600, 100,
            0, 300,
            100, 300,
            200, 300,
            300, 300,
            200, 400,
            300, 400,
            500, 400, 
            600, 400, 
            0, 500,
            100, 500,
            200, 500,
            300, 500,
            400, 500,
            500, 500,
            600, 500,
            700, 500,
            0, 600,
            100, 600,
            200, 600,
            300, 600,
            400, 600,
            500, 600,
            600, 600,
            0, 700,
            100, 700,
            200, 700,
            300, 700,
            400, 700,
            500, 700,
            0, 900,
            100, 900,
            200, 900,
            300, 900,
            400, 900,
            500, 900,
            600, 900,
            700, 900,
            800, 900,
            900, 900,
            1000, 900,
            1000, 800,
            0, 800,
            100, 800,
            200, 800,
            300, 800,
            400, 800,
            500, 800
        );

        sprite.defineSequence("Stand", 0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3);
        sprite.defineSequence("Fly", 5, 5, 6, 6, 7, 7, 8, 8, 9, 9);
        sprite.defineSequence("Fall", 10);
        sprite.defineSequence("Run", 11, 11, 12, 12, 13, 13, 14, 14);
        sprite.defineSequence("Crouch", 15);
        sprite.defineSequence("Crouch Attack", 15, 16, 17, 18);
        sprite.defineSequence("Basic Combo", 19, 20, 21, 22, 23, 24, 25, 26);
        sprite.defineSequence("Forward Smash", 27, 28, 29, 30, 31, 32, 33);
        sprite.defineSequence("Downward Smash", 34, 35, 36, 37, 38, 39);
        sprite.defineSequence("Upward Smash", 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51);
        sprite.defineSequence("Ice Shot", 52, 53, 54, 55, 56, 57);

        sprite.play("Stand");
    }

    /**
     * This plays the sequence of whatever the ice climber will do when each key is pressed
     */
    void keyPressed(String str)
    {
        if(!charCollided)
            sprite.defineSequence("Stand", 10);
        else 
            sprite.defineSequence("Stand", 0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3);

        if(str.equals("WandA"))
        {
            charY = charY - 7;
            charX = charX - 7;
            charHeadedRight = false;
            sprite.play("Fly");
        }
        else if(str.equals("WandD"))
        {
            charY = charY - 7;
            charX = charX + 7;
            charHeadedRight = true;
            sprite.play("Fly");
        }
        else if(str.equals("W"))
        {
            charY = charY - 7;
            sprite.play("Fly");
        }
        else if(str.equals("D"))
        {
            charX = charX + 7;
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
        else if(str.equals("A"))
        {
            charX = charX - 7;
            charHeadedRight = false;
            if(!charCollided)
                sprite.play("Fall");
            else 
                sprite.play("Run");
        }
        else if(str.equals("S"))
        {
            if(charCollided)
                sprite.play("Crouch");
        }
        else if(str.equals("RandS"))
        {
            if(charCollided)
                sprite.play("Crouch Attack");
        }
        else if(str.equals("R"))
        {
            if(charCollided)    
                sprite.play("Ice Shot");
        }
        else if(str.equals("TandA"))
        {
            if(charCollided)
            {
                charHeadedRight = false;
                sprite.play("Forward Smash");
            }
        }
        else if(str.equals("TandD"))
        {
            if(charCollided)
            {
                charHeadedRight = true;
                sprite.play("Forward Smash");
            }
        }
        else if(str.equals("TandS"))
        {
            if(charCollided)
            {
                sprite.play("Downward Smash");
            }
        }
        else if(str.equals("TandW"))
        {
            if(charCollided)
            {
                sprite.play("Upward Smash");
            }
        }
        else if(str.equals("T"))
        {
            if(charCollided)
                sprite.play("Basic Combo");
        }
    }
}
