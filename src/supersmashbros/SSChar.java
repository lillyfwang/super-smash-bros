package supersmashbros;

import ucigame.*;

public class SSChar
{
    public Sprite sprite;
    int health;
    char leftKey;
    Image picture;
    int charX, charY, charSpeed, damage;
    boolean charHeadedRight, charCollided, hit;
    final int MILD = 3;
    final int HEAVY = 8;
    static final int DEAD = 149;

    SSChar(Sprite s, Image i, int ii, int iii, boolean b)
    {
        sprite = s;
        picture = i;
        charSpeed = ii;
        charHeadedRight = b;   
        sprite.framerate(iii);
        damage = 0;
    }

    /**
     * defines all the images, defines the sequences
     */
    void setup()
    {
        //overriden in each subclass
    }

    Sprite getSprite()
    {
        return sprite;
    }

    void setCharX(int x)
    {
        charX = x;
    }

    int getCharX()
    {
        return charX;
    }

    void setCharY(int y)
    {
        charY = y;
    }

    int getCharY()
    {
        return charY;
    }

    void setCharSpeed(int ss)
    {
        charSpeed = ss;
    }

    int getCharSpeed()
    {
        return charSpeed;
    }

    void setHeadedRight(boolean bool)
    {
        charHeadedRight = bool;
    }

    boolean getHeadedRight()
    {
        return charHeadedRight;
    }

    void setCharCollided(boolean boo)
    {
        charCollided = boo;
    }

    boolean getCharCollided()
    {
        return charCollided;
    }

    void setHit(boolean boole)
    {
        hit = boole;
    }

    boolean getHit()
    {
        return hit;
    }

    /**
     *  moves the sprite, reversing directions at the edge of the screen
     */
    void moveCharXAxis(int other)
    {
        if(charX + sprite.width() >= other)
        {
            charHeadedRight = false;
            charSpeed = - charSpeed;
        }
        else if(charX <= 0 )
        {
            charHeadedRight = true;
            charSpeed = - charSpeed;
        }
    }

    /**
     * moves the character down by a factor of "gravity", if it is in the air
     */
    void moveGravity(int gravity)
    {
        if(!sprite.collided())
        {
            charY = charY + gravity;
        }
    }

    /**
     * changes the direction of the sprite
     */
    void changeDirection()
    {
        if(!charHeadedRight)
        {
            sprite.flipHorizontal();
        }
    }

    /**
     * checks to see if the sprite is in the range of the screen
     */
    boolean inBounds(int other)
    {
        return charY < other - sprite.height();
    }

    /**
     * Plays a certain sequence of images and moves the character depending on what "attack" 
     * is passed in. 
     */
    void keyPressed(String str)
    {
        //overridden in each subclass
    }

    /**
     * set's the amount of damage depending on the type of hit (a hit that requires two keys 
     * simultaneously is considered a heavy hit). It also moves the character depending on 
     * what direciton the hit comes from.
     * 
     */
    void setDamage(int a, boolean b)
    {
        if(a < 0)
        {
            damage = damage + MILD;
        }
        else if( a > 0)
        {
            damage = damage + HEAVY;
        }
        hit = false;
        moveBCHit(b);
    }

    int getDamage()
    {
        return damage;
    }

    /**
     * moves the character who has been hit by 20 pixels in the direction of the hit (what 
     * direction the other character is facing, which is passed in).
     * 
     */
    void moveBCHit(boolean otherHeadedRight)
    {
        if(otherHeadedRight)
        {
            charX = charX + 20;
        }
        else
        {
            charX = charX - 20;
        }
        sprite.play("Crouch");
    }
}