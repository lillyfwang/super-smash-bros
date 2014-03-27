
import ucigame.*;
/**
 * This is the main running class of Super Smash Brothers. It has a start screen, a choice of two worlds,
 * and two sprites (kirby/iceclimbers) to play each other. This is the main graphics part.
 */
public class Game extends Ucigame
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * WORLD VARIABLES
     */    
    Sprite button1;
    Sprite button2;
    Sprite block;
    Sprite block1;
    Sprite block2;
    Sprite bounds;
    Sprite bottomland;
    Sprite middlelandleft;
    Sprite middlelandright;
    Sprite topland;
    Image checking;
    final int blockwidth=29;
    final int blocklength=32;
    final int bottomfloorlevel=500;//what y coordinate that each floor is on
    final int middlefloorlevel=325;//what y coordinate that each floor is on
    final int upperfloorlevel=150;//what y coordinate that each floor is on
    final int beginning=70; // the x coordinate of the placement of the picture of the worlds in the "choose world" section
    final int w = 240; // width of the picture of the worlds in the choose world section
    final int h = 238; //length of the picture of the worlds in the choose world section
    final int numbottom=25;
    final int numblock=5;
    final int leftfloorlevel=419; // floor level for the dream land world
    final int rightfloorlevel=413;
    final int upperfloorlevel1=344; //upper floor level for the 2nd world (dream land)
    final int bottomfloorlevel1=552;
    final int blockwidth1=22; //the block width for the dream land (anything with 1 is for dream land)
    final int blocklength1=17;
    final int GRAVITY = 3;
    static final int DEAD = 150;
    Sound maintheme = getSound("sounds/ssbmenu.wav");
    Sound okay = getSound("sounds/menu-ok.wav");
    Sound go = getSound("sounds/Go.wav");
    SSChar k;
    SSChar ic;
    SSChar[] chars = new SSChar[10];

    /**
     * KIRBY VARIABLES
     */
    Sprite kirby2;
    Sound punch = getSound("sounds/kirby/punch.wav");
    Sound kirbyhammer = getSound("sounds/kirby/hammer.wav");
    Sound suckin = getSound("sounds/kirby/suckin.wav");
    Sound flying = getSound("sounds/kirby/flying.wav");
    Sound kirbydying = getSound("sounds/kirby/dying.wav");
    Image kicon = getImage("images/kirbyicon.png");

    /**
     * ICE CLIMBERS VARIABLES
     */

    Sprite iceclimbers2;
    Sound crouch = getSound("sounds/ice/crouch.wav");
    Sound icdying = getSound("sounds/ice/dying.wav");
    Sound ha = getSound("sounds/ice/ha.wav");
    Sound ichammer = getSound("sounds/ice/hammer.wav");
    Sound hammer2 = getSound("sounds/ice/hammer2.wav");
    Sound hit = getSound("sounds/ice/hit.wav");
    Sound ice = getSound("sounds/ice/ice.wav");
    Sound icespray = getSound("sounds/ice/icespray.wav");
    Sound jump = getSound("sounds/ice/jump.wav");
    Sound ya = getSound("sounds/ice/ya.wav");
    Image icicon = getImage("images/iceclimbicon.png");

    /**
     * PERCENTAGES VARIABLES
     */
    Sprite percentagesk;
    Sprite percentagesic;
    Percentages percentk;
    Percentages percentic;

    /**
     * This sets up the welcome screen with a start button.
     */
    public void setup()
    {
        window.size(1000, 750);
        window.title("Push Me");
        framerate(20);
        window.showFPS();
        checking= getImage("images/title.jpg",0);
        button1 = makeButton("Play",
            getImage("images/Button_Design_cropped.jpg", 0 ), //button that says play
            245,71);
        button1.position(canvas.width()/2 - button1.width()/2,
            2*canvas.height()/3 - button1.height()/2);
        canvas.background(checking);
        maintheme.play();
    }

    public void draw()
    {
        canvas.clear();
        button1.draw();
    }

    /**
     * This is called when the start button is pressed and brings you to the choose world menu.
     */
    public void onClickPlay()
    {
        okay.play();
        startScene("ChooseWorld");
    }

    /**
     * This is the setup for the choose world menu. There are two worlds you can choose from:
     * Mario World and Dream Land.
     */
    public void startChooseWorld() //page for choosing the world will be called
    {
        window.showFPS();
        Image titlepic= getImage("images/kirby-background.jpg",0);
        canvas.background(titlepic);
        button1 = makeButton("MarioWorld",
            getImage("images/world1.jpg", 0 ),
            w,h);
        button1.position(beginning,
            canvas.height()/6);
        button2 = makeButton("DreamLand", 
            getImage("images/dreamland-button.jpg",0),
            w,h);                         
        button2.position(beginning,
            canvas.height()/6+ 50 + h);
    }

    public void drawChooseWorld()
    {
        canvas.clear();
        button1.draw();
        button2.draw();
    }

    public void onClickMarioWorld()
    {
        okay.play();
        maintheme.loop();
        startScene("PlayMario");
    }

    /**
     * This is the setup for Mario World. It creates the background and four sprites for the land (bottom,
     * middle (right/left), and top). It also puts a kirby and ice climber into the world. Finally, it 
     * sets up a percentage tracker for both characters.
     */
    public void startPlayMario()
    {
        go.play();
        checking= getImage("images/marioworld2.png");
        canvas.background(checking);
        bounds= makeSprite(blocklength, blocklength);
        bounds.addFrame(getImage("images/blocks1.png", 0), 560, 350);

        /**
         * KIRBY SETUP
         */

        kirby2 = makeSprite(100, 100);
        Image kpic = getImage("images/thereisnochargeforawesomeness.png", 0);
        k = new Kirby(kirby2, kpic, 2, 15, true);
        chars[0] = k;

        chars[0].getSprite().play("Stand");
        chars[0].setCharX(300);
        chars[0].setCharY(canvas.height()/2 - chars[0].getSprite().height()/2-100);

        /**
         * ICE CLIMBERS SETUP
         */
        iceclimbers2 = makeSprite(100, 100);
        Image icpic = getImage("images/iceclimbersfinal2.png", 0);
        ic = new IceClimbers(iceclimbers2, icpic, 2, 12, false);
        chars[1] = ic;

        chars[1].getSprite().play("Stand");
        chars[1].setCharX(600);
        chars[1].setCharY(canvas.height()/2 -  chars[1].getSprite().height()/2-100);

        /**
         * PERCENTAGES SETUP
         */
        percentagesk = makeSprite(150,80);
        percentagesic = makeSprite(150,80);
        Image ppic = getImage("images/percentages.png",0);
        percentk = new Percentages(percentagesk, ppic, 0);
        percentic = new Percentages(percentagesic, ppic, 0);
    }    

    public void drawPlayMario()
    {
        canvas.clear();

        //from this point, these codes are for making the floor
        bottomland = makeSprite(getImage("images/block.png",0),795,32);
        bottomland.position(95,bottomfloorlevel);
        bottomland.draw();

        middlelandleft = makeSprite(getImage("images/block.png",0),235,32);
        middlelandleft.position(150,middlefloorlevel);
        middlelandleft.draw();

        middlelandright = makeSprite(getImage("images/block.png",0),235,32);
        middlelandright.position(590,middlefloorlevel);
        middlelandright.draw();

        topland = makeSprite(getImage("images/block.png",0),370,32);
        topland.position(300,upperfloorlevel);
        topland.draw();

        block1=makeSprite(blockwidth, blocklength); //block one is the first part of the support thing...
        block1.addFrame(getImage("images/blocks1.png",0),39,342);
        block1.position(81,bottomfloorlevel);//bottom part left edge
        block1.draw();

        block1.position(121,middlefloorlevel); //left, middle floor left edge
        block1.draw();

        block1.position(561,middlefloorlevel); //right, middle floor left edge
        block1.draw();

        block1.position(271,upperfloorlevel); //center, top floor left edge
        block1.draw();

        block2=makeSprite(blocklength,blocklength);//block two is the end of the support thing (block, or ground thingy)
        block2.addFrame(getImage("images/blocks1.png",0),138,342);
        block2.position(890,bottomfloorlevel); //the bottom floor right edge
        block2.draw();

        block2.position(380,middlefloorlevel); //left, middle floor right edge
        block2.draw();

        block2.position(820,middlefloorlevel); //right, middle floor right edge
        block2.draw();

        block2.position(670,upperfloorlevel); //top center, floor right edge
        block2.draw();

        /**
         * KIRBY DRAW
         */

        chars[0].moveCharXAxis(canvas.width());
        if (chars[0].inBounds(canvas.height())) //this makes sure that kirby falls when it is in the air
        {
            chars[0].getSprite().checkIfCollidesWith(topland, bottomland, middlelandleft, middlelandright, PIXELPERFECT);
            chars[0].moveGravity(GRAVITY);
        }
        chars[0].getSprite().position(chars[0].getCharX(), chars[0].getCharY());
        chars[0].changeDirection();
        chars[0].getSprite().draw();
        if (chars[0].getDamage()>=SSChar.DEAD)
        {
            kirbydying.play();
            chars[0].getSprite().position(1000,1000);//makes it unable to detect sprites
        }

        /**
         * ICE CLIMBERS DRAW
         */

        chars[1].moveCharXAxis(canvas.width());
        if (chars[1].inBounds(canvas.height()))//this makes sure that IC falls when it is in the air
        {
            chars[1].getSprite().checkIfCollidesWith(topland, bottomland, middlelandleft, middlelandright, PIXELPERFECT);
            chars[1].moveGravity(GRAVITY);
        }
        chars[1].getSprite().position(chars[1].getCharX(), chars[1].getCharY());
        chars[1].changeDirection();
        chars[1].getSprite().draw();
        if (chars[1].getDamage()>=SSChar.DEAD)
        {
            icdying.play();
            chars[1].getSprite().position(1000,1000);//makes it unable to detect sprites
        }

        /**
         * PERCENTAGES DRAW
         */
        kicon.draw(130, 555);
        percentk.getSprite().position(200, 545);
        percentk.getSprite().draw();
        percentk.getSprite().play("0");
        percentk.getDamage(chars[0].getDamage());
        percentk.illustrate();

        icicon.draw(600,555);
        percentic.getSprite().position(670, 545);
        percentic.getSprite().draw();
        percentic.getSprite().play("0");
        percentic.getDamage(chars[1].getDamage());
        percentic.illustrate();
    }

    public void onClickDreamLand()
    {
        startScene("PlayDreamLand");      
        okay.play();
        go.play();
        maintheme.loop();
    }

    /**
     * This is the setup for DreamLand. It creates the background and four sprites for the land (bottom,
     * middle (right/left), and top). It also puts a kirby and ice climber into the world. Finally, it 
     * sets up a percentage tracker for both characters.
     */
    public void startPlayDreamLand()
    {
        checking=getImage("images/dreamland.png");
        canvas.background(checking);
        middlelandleft= makeSprite(109, 17);
        middlelandright= makeSprite(109,17);
        topland = makeSprite(119,17);
        bottomland = makeSprite(541,37);
        bounds=makeSprite(blocklength,blocklength);
        bounds.addFrame(getImage("images/dreamland.png", 0), 560, 350);
        middlelandleft.addFrame(getImage("images/dreamland.png",0),277,417);
        middlelandright.addFrame(getImage("images/dreamland.png",0),628,411);
        topland.addFrame(getImage("images/dreamland.png",0),444,342);
        bottomland.addFrame(getImage("images/dreamland.png",0),248,549);

        /**
         * KIRBY SETUP
         */

        kirby2 = makeSprite(100, 100);
        Image kpic = getImage("images/thereisnochargeforawesomeness.png", 0);
        k = new Kirby(kirby2, kpic, 2, 15, true);
        chars[0] = k;

        //  chars[0].getSprite().play("Stand");
        chars[0].setCharX(300);
        chars[0].setCharY(canvas.height()/2 - chars[0].getSprite().height()/2);

        /**
         * ICE CLIMBERS SETUP
         */
        iceclimbers2 = makeSprite(100, 100);
        Image icpic = getImage("images/iceclimbersfinal2.png", 0);
        ic = new IceClimbers(iceclimbers2, icpic, 2, 12, false);
        chars[1] = ic;

        chars[1].getSprite().play("Stand");
        chars[1].setCharX(600);
        chars[1].setCharY(canvas.height()/2 -  chars[1].getSprite().height()/2);

        /**
         * PERCENTAGES SETUP
         */
        percentagesk = makeSprite(150,80);
        percentagesic = makeSprite(150,80);
        Image ppic = getImage("images/percentages.png",0);
        percentk = new Percentages(percentagesk, ppic, 0);
        percentic = new Percentages(percentagesic, ppic, 0);
    }

    public void drawPlayDreamLand()
    {
        canvas.clear();
        //from this point, these codes are for making the floor

        middlelandleft.position(277,418);
        middlelandleft.draw();

        middlelandright.position(628,412);
        middlelandright.draw();

        topland.position(444,343);
        topland.draw();

        bottomland.position(248,549);
        bottomland.draw();

        /**
         * KIRBY DRAW
         */

        chars[0].moveCharXAxis(canvas.width());
        if (chars[0].inBounds(canvas.height()))//this makes sure that kirby falls when it is in the air
        {
            chars[0].getSprite().checkIfCollidesWith(topland, bottomland, middlelandleft, middlelandright, PIXELPERFECT);
            chars[0].moveGravity(GRAVITY);
        }
        chars[0].getSprite().position(chars[0].getCharX(), chars[0].getCharY());
        chars[0].changeDirection();
        chars[0].getSprite().draw();
        if (chars[0].getDamage()>=SSChar.DEAD)
        {
            kirbydying.play();
            chars[0].getSprite().position(1000,1000);//makes it unable to detect sprites
        }

        /**
         * ICE CLIMBERS DRAW
         */

        chars[1].moveCharXAxis(canvas.width());
        if (chars[1].inBounds(canvas.height()))//this makes sure that kirby falls when it is in the air
        {
            chars[1].getSprite().checkIfCollidesWith(topland, bottomland, middlelandleft, middlelandright, PIXELPERFECT);
            chars[1].moveGravity(GRAVITY);
        }
        chars[1].getSprite().position(chars[1].getCharX(), chars[1].getCharY());
        chars[1].changeDirection();
        chars[1].getSprite().draw();
        if (chars[1].getDamage()>=SSChar.DEAD)
        {
            icdying.play();
            chars[1].getSprite().position(1000,1000);//makes it unable to detect sprites
        }

        /**
         * PERCENTAGES DRAW
         */
        kicon.draw(130, 555);
        percentk.getSprite().position(200, 545);
        percentk.getSprite().position(150, 550);
        percentk.getSprite().draw();
        percentk.getSprite().play("0");
        percentk.getDamage(chars[0].getDamage());
        percentk.illustrate();

        icicon.draw(600,555);
        percentic.getSprite().position(670, 545);
        percentic.getSprite().draw();
        percentic.getSprite().play("0");
        percentic.getDamage(chars[1].getDamage());
        percentic.illustrate();
    }
    
    /**
     * This keeps track of what buttons are pressed. When specific buttons are pressed, it passes in a
     * String to the Kirby and Ice Climbers classes. The graphics will change corresponding to what
     * combinations of buttons pressed.
     */
    public void onKeyPress()
    {
        /**
         * KIRBY KEYS
         */

        chars[0].getSprite().checkIfCollidesWith(topland, bottomland, middlelandleft, middlelandright, PIXELPERFECT);
        chars[0].setCharCollided(chars[0].getSprite().collided());
        chars[0].getSprite().checkIfCollidesWith(chars[1].getSprite(), PIXELPERFECT);
        chars[1].setHit(chars[0].getSprite().collided());

        if (keyboard.isDown(keyboard.UP) && keyboard.isDown(keyboard.LEFT))
        {
            chars[0].keyPressed("UPandLEFT");
            flying.play();
        }
        else if (keyboard.isDown(keyboard.UP) && keyboard.isDown(keyboard.RIGHT))
        {
            chars[0].keyPressed("UPandRIGHT");
            flying.play();
        }

        else if(keyboard.isDown(keyboard.PERIOD) && keyboard.isDown(keyboard.LEFT))
        {
            chars[0].keyPressed("PERIODandLEFT");
            if(chars[0].getCharCollided())
            {
                kirbyhammer.play();
                if(chars[1].getHit())
                    chars[1].setDamage(1, chars[0].getHeadedRight());
            }
        }
        else if (keyboard.isDown(keyboard.PERIOD) && keyboard.isDown(keyboard.RIGHT))
        {
            chars[0].keyPressed("PERIODandRIGHT");
            if(chars[0].getCharCollided())
            {
                kirbyhammer.play();
                if(chars[1].getHit())
                    chars[1].setDamage(1, chars[0].getHeadedRight());
            }
        }
        else if(keyboard.isDown(keyboard.PERIOD) && keyboard.isDown(keyboard.DOWN))
        {
            chars[0].keyPressed("PERIODandDOWN");
            if(chars[0].getCharCollided())
            {
                if(chars[1].getHit())
                    chars[1].setDamage(1, chars[0].getHeadedRight());
            }
        }
        else if(keyboard.isDown(keyboard.PERIOD))
        {
            chars[0].keyPressed("PERIOD");
            if(chars[0].getCharCollided())
            {    
                suckin.play();
                if(chars[1].getHit())
                    chars[1].setDamage(-1, chars[0].getHeadedRight());
            }
        }
        else if (keyboard.isDown(keyboard.COMMA))
        {
            chars[0].keyPressed("COMMA");
            if(chars[0].getCharCollided())
            {
                punch.play();
                if(chars[1].getHit())
                    chars[1].setDamage(-1, chars[0].getHeadedRight());
            }
        }
        else if (keyboard.isDown(keyboard.DOWN))
        {
            chars[0].keyPressed("DOWN");
            if(!chars[0].getCharCollided())
            {
                if(chars[1].getHit())
                    chars[1].setDamage(-1, chars[0].getHeadedRight());
            }
        }
        else if (keyboard.isDown(keyboard.UP))
        {
            chars[0].keyPressed("UP");
            flying.play();
        }
        else if (keyboard.isDown(keyboard.RIGHT))
        {
            chars[0].keyPressed("RIGHT");
        }
        else if (keyboard.isDown(keyboard.LEFT))
        {
            chars[0].keyPressed("LEFT");
        }
        else
            chars[0].getSprite().play("Stand");

        /**
         * ICE CLIMBERS KEYS
         * 
         */

        chars[1].getSprite().checkIfCollidesWith(topland, bottomland, middlelandleft, middlelandright, PIXELPERFECT);
        chars[1].setCharCollided(chars[1].getSprite().collided());
        chars[1].getSprite().checkIfCollidesWith(chars[0].getSprite(), PIXELPERFECT);
        chars[0].setHit(chars[1].getSprite().collided());

        if (keyboard.isDown(keyboard.W) && keyboard.isDown(keyboard.A))
        {
            chars[1].keyPressed("WandA");
            jump.play();
        }
        else if (keyboard.isDown(keyboard.W) && keyboard.isDown(keyboard.D))
        {
            chars[1].keyPressed("WandD");
            jump.play();
        }
        else if(keyboard.isDown(keyboard.R) && keyboard.isDown(keyboard.S))
        {
            chars[1].keyPressed("RandS");
            if(chars[1].getCharCollided())
            {
                crouch.play();
                if(chars[0].getHit())
                    chars[0].setDamage(1, chars[1].getHeadedRight());
            }
        }
        else if(keyboard.isDown(keyboard.T) && keyboard.isDown(keyboard.A))
        {
            chars[1].keyPressed("TandA");
            if(chars[1].getCharCollided())
            {
                hammer2.play();
                if(chars[0].getHit())
                    chars[0].setDamage(1, chars[1].getHeadedRight());
            }
        }
        else if (keyboard.isDown(keyboard.T) && keyboard.isDown(keyboard.D))
        {
            chars[1].keyPressed("TandD");
            if(chars[1].getCharCollided())
            {
                hammer2.play();
                if(chars[0].getHit())
                    chars[0].setDamage(1, chars[1].getHeadedRight());
            }
        }
        else if(keyboard.isDown(keyboard.T) && keyboard.isDown(keyboard.S))
        {
            chars[1].keyPressed("TandS");
            if(chars[1].getCharCollided())
            {
                hammer2.play();
                if(chars[0].getHit())
                    chars[0].setDamage(1, chars[1].getHeadedRight());
            }
        }
        else if(keyboard.isDown(keyboard.T) && keyboard.isDown(keyboard.W))
        {
            chars[1].keyPressed("TandW");
            if(chars[1].getCharCollided())
            {
                hammer2.play();
                if(chars[0].getHit())
                    chars[0].setDamage(1, chars[1].getHeadedRight());
            }
        }
        else if(keyboard.isDown(keyboard.T))
        {
            chars[1].keyPressed("T");
            if(chars[1].getCharCollided())
            {
                ichammer.play();
                if(chars[0].getHit())
                    chars[0].setDamage(-1, chars[1].getHeadedRight());
            }
        }
        else if (keyboard.isDown(keyboard.R))
        {
            chars[1].keyPressed("R");
            if(chars[1].getCharCollided())
            {
                if(chars[0].getHit())
                    chars[0].setDamage(-1, chars[1].getHeadedRight());
            }
        }
        else if (keyboard.isDown(keyboard.W))
        {
            chars[1].keyPressed("W");
            jump.play();
        }
        else if (keyboard.isDown(keyboard.D))
        {
            chars[1].keyPressed("D");
        }
        else if (keyboard.isDown(keyboard.A))
        {
            chars[1].keyPressed("A");
        }
        else if (keyboard.isDown(keyboard.S)) 
            chars[1].keyPressed("S");
        else 
        {
            chars[1].getSprite().play("Stand");
        }
    }

    public void onKeyRelease()
    {
        chars[0].getSprite().play("Stand");
        chars[1].getSprite().play("Stand");
    }
}