/*
 * Hints frame class Class
 * @author �a�an �nen, Mustafa Furkan Ayaz
 * @version 12/05/2018
 */
package level.properties;

import engineTester.Game;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;

public class LevelProperties extends javax.swing.JFrame 
{
  // Constants
  private static final float GRAVITY = 9.81f;
  private static final float WIDTH_OF_FIELD = 40f; // meters
  private static final float HEIGHT_OF_FIELD = 40f; // meters
  private static final float HEIGHT_OF_OBSTACLES = 3f; // meters
  private static final float HEIGHT_OF_GOALPOSTS = 2.5f; // meters
  private static final float WIDTH_OF_GOALPOSTS = 7.5f; // meters
  
  // Properties
  protected Game game;
  protected String cityName;
  protected String realCityName;
  protected float[] wind;
  protected float[] positions;
  protected float[] velocity;
  protected float windVectorX;
  protected float windVectorY;
  protected float windVectorZ;
  protected float coefficientOfFriction;
  protected float obstacleCoordinateX1;
  protected float obstacleCoordinateZ1;
  protected float obstacleCoordinateX2;
  protected float obstacleCoordinateZ2;
  protected float xCoordinateOfPlayer;
  protected float zCoordinateOfPlayer;
  protected float velocityX;
  protected float velocityY;
  protected float velocityZ;
  protected boolean isFirstTrial;
  protected DecimalFormat df;
  
  // User interface components
  private javax.swing.JButton approveButton;
  private javax.swing.JButton calculatorButton;
  private javax.swing.JLabel cityNameLabel;
  private javax.swing.JLabel coordinatesOfFirstObstacle;
  private javax.swing.JLabel coordinatesOfGoalposts;
  private javax.swing.JLabel coordinatesOfSecondObstacle;
  private javax.swing.JLabel coordinatesOfThirdObstacle;
  private javax.swing.JLabel distanceObstaclesLabel;
  private javax.swing.Box.Filler filler1;
  private javax.swing.JLabel goalpostsHeightLabel;
  private javax.swing.JLabel gravityLabel;
  private javax.swing.JButton hintButton;
  private javax.swing.JLabel infoLabel;
  private javax.swing.JLabel frictionLabel;
  private javax.swing.JLabel obstaclesHeader;
  private javax.swing.JLabel goalPostsHeader;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel obstacleHeightLabel;
  private javax.swing.JLabel playerCoordinates;
  private javax.swing.JLabel sliderTextX;
  private javax.swing.JLabel sliderTextY;
  private javax.swing.JLabel sliderTextZ;
  private javax.swing.JLabel velocityLabel;
  private javax.swing.JLabel windLabel;
  private javax.swing.JLabel windVectorLabel;
  private javax.swing.JSlider xSlider;
  private javax.swing.JSlider ySlider;
  private javax.swing.JSlider zSlider;
  
  // Constructor
  /**
   * constructor for the levelProperties class
   * @param cityName location of the football field
   **/
  public LevelProperties ( String cityName ) 
  {
    
    // initize main ui components
    setResizable(false);
    setBackground(Color.GREEN);
    setTitle("Level Properties");
    getContentPane().setFont(new Font("Stencil", Font.PLAIN, 15));
    getContentPane().setBackground(new Color(127, 255, 0));
    initComponents();
    
    // create a decimal format to format some constants
    df = new DecimalFormat ( );
    df.setMaximumFractionDigits( 2 );
    
    // display city name 
    setCityName ( cityName );
    
    //display gravity
    gravityLabel.setText( "Gravity: " + GRAVITY );
    
    // set obstacle height and goal posts height label
    obstacleHeightLabel.setText ( "Height of Obstacles: " + HEIGHT_OF_OBSTACLES + " m " );
    goalpostsHeightLabel.setText ( "Height of Goalposts: " + HEIGHT_OF_GOALPOSTS + " m " );
    
    // initialize places of the goal posts, players, obstacles and set their labels
    setFriction();
    setgoalpostsCoordinates();
    setPlayerCoordinates();
    placeObstacles();
    setObstacleLabel();
    createWind();
    setCityLabel();
    
    // initialize isFirstTrial true to give the formulas to the user at the beginning as hint 
    isFirstTrial = true;
  }
  
  /**
   * determines the coefficient of static friction on the grass
   */
  private void setFriction()
  {
    //determine coefficient of friction
    coefficientOfFriction = random ( 0,1 ) ;
    frictionLabel.setText ( "Coefficient of Friction:" + df.format ( coefficientOfFriction ) );
  }
  
  /**
   * displays the coordinates of the goal posts
   */
  private void setgoalpostsCoordinates()
  {
    coordinatesOfGoalposts.setText( "Coordinates of the Goalpost ( z,x ): " + "( " + 0 + ", " +  WIDTH_OF_FIELD / 2 + " )" );
  }
  
  /**
   * sets players coordinates randomly 
   */
  private void setPlayerCoordinates()
  {
    //determine coordinates of the player
    positions[0] = ( -1 ) * Math.round ( random ( HEIGHT_OF_FIELD / 8, HEIGHT_OF_FIELD / 2 ) ); //x
    positions[1] = Math.round ( random ( ( -1 ) * WIDTH_OF_FIELD / 2, WIDTH_OF_FIELD / 2 ) ); //z
    playerCoordinates .setText( "Coordinates of the player (z,x): " + "( " + positions [ 1 ] + ", " + positions [ 0 ] + " )" );
  }
  
  /**
   * displays the coordinates of the obstacles
   */
  private void setObstacleLabel()
  {
    //set obstacle distance label
    distanceObstaclesLabel.setText( "Coordinates of the Obstacles ( z,x ): " );
    coordinatesOfFirstObstacle.setText( "( " + positions [ 2 ] + ", " + positions [ 3 ] + " )" );
    coordinatesOfSecondObstacle.setText( "( " + positions[ 4 ] + ", " + positions [ 5 ] + " )" );
    coordinatesOfThirdObstacle.setText( "( " + positions[ 6 ] + ", " + positions [ 7 ] + " )" );
  }
  
  /**
   * gets the choice from the world map and displays the name of the city
   */
  private void setCityLabel()
  {
    // Make the first letter of the city upper case
    realCityName = cityName.substring(0, 1).toUpperCase();
    
    for (int i = 1; i < cityName.length(); i++) 
    {
      if ( cityName.charAt(i) < 91 )
        realCityName += " ";
      realCityName += cityName.charAt ( i );
    }
    cityNameLabel.setText ( "City: " + realCityName );
  }
  
  /**
   * creates the wind vector according to the location and displays it
   */
  private void createWind()
  {
    // determine wind vector according to location
    if (cityName.equals("waikikiBeach")) 
    {
      wind[0] = random(-7, 7); // z component
      wind[1] = random(-4, 4); // x component
      wind[2] = random(-3, 3); // y component
    }
    
    // Average wind speed = 3.26 m/s
    if (cityName.equals("chichenItza")) 
    {
      wind[0] = random(-3, 3); // z component
      wind[1] = random(-2, 2); // x component
      wind[2] = random(-2, 2); // y component
    }
    
    // Average wind speed = 5.81 m/s
    if (cityName.equals("westminster")) 
    {
      wind[0] = random(-6, 6); // z component
      wind[1] = random(-4, 4); // x component
      wind[2] = random(-3, 3); // y component
    }
    
    // no wind 
    if (cityName.equals("hagiaSophia")) 
    {
      wind[0] = 0; // z component
      wind[1] = 0; // x component
      wind[2] = 0; // y component
    }
    
    // Average wind speed = 3.21 m/s
    if (cityName.equals("forbiddenCity")) 
    {
      wind[0] = random(-3, 3); // z component
      wind[1] = random(-2, 2); // x component
      wind[2] = random(-2, 2); // y component
    }
    
    // Average wind speed = 5.45 m/s
    if ( cityName.equals ( "tableMountain") ) {
      wind[0] = random( -6, 6 ); // z component
      wind[1] = random( -3, 3 ); // x component
      wind[2] = random( -3, 3 ); // y component
    }
    
    // Average wind speed = 3.66 m/s
    else 
    {
      wind[0] = random( -4, 4 ); // z component
      wind[1] = random( -3, 3 ); // x component
      wind[2] = random( -3, 3 ); // y component
    }
    
    df.setMaximumFractionDigits( 1 );
    String windZ = df.format ( wind[0] ); // z component
    String windX = df.format ( wind[1] ); // x component
    String windY = df.format ( wind[2] ); // y component
    
    // display the wind vector
    windVectorLabel.setText ( "( " + windX + ", " +  windY + ", " +  windZ + " )" );
  }
  
  /**
   * randomize places of the obstacles
   */
  private void placeObstacles ()
  {
    // randomize z coordinates
    positions[2] = Math.round ( placeObstaclesZ() );
    positions[4] = Math.round ( placeObstaclesZ() );
    positions[6] = Math.round ( placeObstaclesZ() );
    
    // randomize x coordinates
    positions[3] = Math.round ( random ( ( -1 ) * HEIGHT_OF_FIELD / 8, 10 ) );
    positions[5] = Math.round ( random ( ( -1 ) * HEIGHT_OF_FIELD / 8, 10 ) );
    positions[7] = Math.round ( random ( ( -1 ) * HEIGHT_OF_FIELD / 8, 10 ) );
  }
  
  /**
   * determines the coordinates of the obstacles and making them near to the player in x axis
   * @return x coordinates of the obstacles
   */
  private float placeObstaclesZ() 
  {
    if ( positions [ 1 ] >= WIDTH_OF_FIELD / 4 ) 
    {
      return random ( 0, positions [ 1 ] );
    } 
    else if ( positions [ 1 ] < 0 && ( -1 ) * positions [ 1 ] >= WIDTH_OF_FIELD / 4) 
    {
      return random( positions [ 1 ], 0);
    } 
    else 
    {
      return random ( positions [ 1 ] - WIDTH_OF_FIELD / 4, positions [ 1 ] + WIDTH_OF_FIELD / 4 );
    }
  }
  
  /**
   * generates a random number in a specified range
   * @param lowerBoundry lower boundry of the range
   * @param upperBoundry upper boundry of the range
   * @return a random float in that range
   *
   */
  private float random(float lowerBoundry, float upperBoundry) 
  {
    float range;
    range = upperBoundry - lowerBoundry;
    return ( float ) (  Math.random()  * range ) + lowerBoundry;
  }
  
  /**
   * initializes user interface components
   * automatically generated code (netbeans)
   */
  private void initComponents() 
  {
    jLabel3 = new javax.swing.JLabel();
    ySlider = new javax.swing.JSlider(-40, 40, 0);
    ySlider.setBackground(new Color(0, 204, 255));
    zSlider = new javax.swing.JSlider(-40, 40, 0);
    zSlider.setBackground(new Color(0, 204, 255));
    xSlider = new javax.swing.JSlider(-40, 40, 0);
    xSlider.setBackground(new Color(0, 204, 255));
    infoLabel = new javax.swing.JLabel();
    infoLabel.setForeground(new Color(0, 0, 0));
    gravityLabel = new javax.swing.JLabel();
    gravityLabel.setForeground(new Color(0, 0, 0));
    gravityLabel.setFont(new Font("Stencil", Font.PLAIN, 15));
    obstacleHeightLabel = new javax.swing.JLabel();
    obstacleHeightLabel.setForeground(new Color(0, 0, 0));
    obstacleHeightLabel.setFont(new Font("Stencil", Font.PLAIN, 15));
    goalpostsHeightLabel = new javax.swing.JLabel();
    goalpostsHeightLabel.setForeground(Color.BLACK);
    goalpostsHeightLabel.setFont(new Font("Stencil", Font.PLAIN, 15));
    distanceObstaclesLabel = new javax.swing.JLabel();
    distanceObstaclesLabel.setForeground(new Color(0, 0, 0));
    distanceObstaclesLabel.setFont(new Font("Stencil", Font.PLAIN, 15));
    hintButton = new javax.swing.JButton();
    hintButton.setBackground(new Color(0, 128, 0));
    calculatorButton = new javax.swing.JButton();
    calculatorButton.setBackground(new Color(0, 128, 0));
    playerCoordinates = new javax.swing.JLabel();
    playerCoordinates.setForeground(Color.BLACK);
    playerCoordinates.setFont(new Font("Stencil", Font.PLAIN, 18));
    velocityLabel = new javax.swing.JLabel();
    sliderTextX = new javax.swing.JLabel();
    sliderTextX.setFont(new Font("Stencil", Font.PLAIN, 15));
    sliderTextY = new javax.swing.JLabel();
    sliderTextY.setFont(new Font("Stencil", Font.PLAIN, 15));
    sliderTextZ = new javax.swing.JLabel();
    sliderTextZ.setFont(new Font("Stencil", Font.PLAIN, 15));
    windLabel = new javax.swing.JLabel();
    windLabel.setForeground(Color.BLACK);
    filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0),
                                         new java.awt.Dimension(0, 32767));
    coordinatesOfGoalposts = new javax.swing.JLabel();
    coordinatesOfGoalposts.setForeground(Color.BLACK);
    coordinatesOfGoalposts.setFont(new Font("Stencil", Font.PLAIN, 15));
    approveButton = new javax.swing.JButton();
    approveButton.setBackground(new Color(0, 128, 0));
    coordinatesOfFirstObstacle = new javax.swing.JLabel();
    coordinatesOfFirstObstacle.setForeground(new Color(0, 0, 0));
    coordinatesOfFirstObstacle.setFont(new Font("Stencil", Font.PLAIN, 15));
    coordinatesOfSecondObstacle = new javax.swing.JLabel();
    coordinatesOfSecondObstacle.setForeground(new Color(0, 0, 0));
    coordinatesOfSecondObstacle.setFont(new Font("Stencil", Font.PLAIN, 15));
    coordinatesOfThirdObstacle = new javax.swing.JLabel();
    coordinatesOfThirdObstacle.setForeground(new Color(0, 0, 0));
    coordinatesOfThirdObstacle.setFont(new Font("Stencil", Font.PLAIN, 15));
    cityNameLabel = new javax.swing.JLabel();
    cityNameLabel.setForeground(new Color(0, 0, 0));
    cityNameLabel.setFont(new Font("Stencil", Font.PLAIN, 15));
    obstaclesHeader = new javax.swing.JLabel();
    obstaclesHeader.setForeground(new Color(0, 0, 0));
    goalPostsHeader = new javax.swing.JLabel();
    goalPostsHeader.setForeground(Color.BLACK);
    wind = new float[3];
    positions = new float[10];
    velocity = new float[3];
    
    jLabel3.setText("jLabel3");
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    ySlider.addChangeListener(new javax.swing.event.ChangeListener() 
                                
    {
      public void stateChanged(javax.swing.event.ChangeEvent evt) 
      {
        ySliderStateChanged(evt);
      }
    });
    
    zSlider.setMajorTickSpacing(1);
    zSlider.addChangeListener(new javax.swing.event.ChangeListener() 
                               
    {
      public void stateChanged(javax.swing.event.ChangeEvent evt) 
      {
        zSliderStateChanged(evt);
      }
    });
    
    xSlider.addChangeListener(new javax.swing.event.ChangeListener() 
                                
    {
      public void stateChanged(javax.swing.event.ChangeEvent evt) 
      {
        xSliderStateChanged(evt);
      }
    });
    
    infoLabel.setFont(new java.awt.Font("Times New Roman", 1, 24));
    infoLabel.setText("General Information");
    
    gravityLabel.setText("Gravity: 9.81");
    
    obstacleHeightLabel.setText("Height of Obstacles: 3.0 m ");
    
    goalpostsHeightLabel.setText("Height of Goalpost ");
    
    distanceObstaclesLabel.setText("Coordinates of the obstacles (x,z) :  ");
    
    hintButton.setFont(new Font("Sitka Small", Font.BOLD, 14)); 
    
    hintButton.setText("HINT");
    hintButton.addActionListener(new java.awt.event.ActionListener() 
                                   
    {
      public void actionPerformed(java.awt.event.ActionEvent evt) 
      {
        hintButtonActionPerformed(evt);
      }
    });
    
    calculatorButton.setFont(new Font("Sitka Small", Font.BOLD, 14));
    calculatorButton.setText("CALCULATOR");
    calculatorButton.addActionListener(new java.awt.event.ActionListener() 
                                         
    {
      public void actionPerformed(java.awt.event.ActionEvent evt) 
      {
        calculatorButtonActionPerformed(evt);
      }
    });
    
    playerCoordinates.setText("Coordinate of the Player ( x,z ): ( 0,0 ) ");
    
    velocityLabel.setFont(new java.awt.Font("Times New Roman", 1, 24));
    velocityLabel.setText("3D Velocity Vector");
    
    sliderTextX.setText("X Axis : 0");
    
    sliderTextY.setText("Y Axis : 0");
    
    sliderTextZ.setText("Z Axis : 0");
    
    windLabel.setFont(new java.awt.Font("Times New Roman", 1, 24));
    windLabel.setText("Wind Vector");
    
    coordinatesOfGoalposts.setText("Coordinates of the Goalposts ( x,z ): ( 0,0 )");
    
    approveButton.setFont(new Font("Sitka Small", Font.BOLD, 14));
    approveButton.setText("APPROVE");
    approveButton.addActionListener(new java.awt.event.ActionListener() 
                                      
    {
      public void actionPerformed(java.awt.event.ActionEvent evt) 
      {
        approveButtonActionPerformed(evt);
      }
    });
    
    coordinatesOfFirstObstacle.setText("jLabel2");
    
    coordinatesOfSecondObstacle.setText("jLabel2");
    
    coordinatesOfThirdObstacle.setText("jLabel4");
    
    cityNameLabel.setText("City: HAGIA SOPHIA");
    
    obstaclesHeader.setFont(new java.awt.Font("Times New Roman", 1, 24));
    obstaclesHeader.setText("Obstacles");
    
    goalPostsHeader.setFont(new java.awt.Font("Times New Roman", 1, 24));
    goalPostsHeader.setText("Goalposts");
    
    frictionLabel = new JLabel("Coefficient of Friction: ");
    frictionLabel.setForeground(new Color(0, 0, 0));
    frictionLabel.setFont(new Font("Stencil", Font.PLAIN, 15));
    
    JButton btnRearrange = new JButton("REARRANGE");
    btnRearrange.setBackground(new Color(0, 128, 0));
    btnRearrange.setFont(new Font("Sitka Small", Font.BOLD, 14));
    btnRearrange.addActionListener(new ActionListener() 
                                     
    {
      public void actionPerformed(ActionEvent arg0) 
      {
        setFriction();
        setgoalpostsCoordinates();
        setPlayerCoordinates();
        placeObstacles();
        setObstacleLabel();
        createWind();
        setCityLabel();
      }
    });
    
    windVectorLabel = new JLabel ( "......." );
    windVectorLabel.setForeground(Color.BLACK);
    windVectorLabel.setFont(new Font("Stencil", Font.PLAIN, 15));
    
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    layout.setHorizontalGroup(
                              layout.createParallelGroup(Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                            .addGap(64)
                                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(gravityLabel)
                                                                    .addGap(281)
                                                                    .addComponent(btnRearrange, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
                                                                    .addGap(173)
                                                                    .addComponent(velocityLabel))
                                                        .addComponent(frictionLabel)
                                                        .addGroup(layout.createSequentialGroup()
                                                                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(infoLabel, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(cityNameLabel)
                                                                                .addComponent(obstaclesHeader)
                                                                                .addComponent(distanceObstaclesLabel)
                                                                                .addComponent(obstacleHeightLabel)
                                                                                .addComponent(coordinatesOfFirstObstacle)
                                                                                .addComponent(coordinatesOfThirdObstacle)
                                                                                .addComponent(coordinatesOfSecondObstacle))
                                                                    .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                    .addGap(144)
                                                                                                                    .addComponent(windLabel))
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                    .addGap(176)
                                                                                                                    .addComponent(windVectorLabel))
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                    .addGap(45)
                                                                                                                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                                                                                                .addComponent(goalpostsHeightLabel, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(coordinatesOfGoalposts))))
                                                                                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                    .addGap(126)
                                                                                                                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                                                                                                .addComponent(sliderTextX)
                                                                                                                                .addComponent(sliderTextY)))
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                    .addGap(25)
                                                                                                                    .addComponent(playerCoordinates)))
                                                                                            .addGap(37))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                            .addGap(168)
                                                                                            .addComponent(goalPostsHeader)
                                                                                            .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                            .addComponent(sliderTextZ)
                                                                                            .addGap(278))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                            .addPreferredGap(ComponentPlacement.RELATED)
                                                                                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                    .addGap(136)
                                                                                                                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                                                                                                .addComponent(approveButton)
                                                                                                                                .addComponent(hintButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(calculatorButton, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
                                                                                                                    .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                    .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                                                                                                                                .addComponent(ySlider, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                                                                                                                                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                                                                                                                        .addComponent(xSlider, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
                                                                                                                                                        .addComponent(zSlider, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
                                                                                                                                            .addGap(72))))
                                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                                    .addComponent(filler1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                                    .addPreferredGap(ComponentPlacement.RELATED, 891, Short.MAX_VALUE)))))))
                                            .addContainerGap())
                             );
    layout.setVerticalGroup(
                            layout.createParallelGroup(Alignment.LEADING)
                              .addGroup(layout.createSequentialGroup()
                                          .addGap(43)
                                          .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                      .addGroup(layout.createSequentialGroup()
                                                                  .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                                                              .addComponent(infoLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                                                              .addComponent(windLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                                                  .addGap(12)
                                                                  .addComponent(cityNameLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                                                  .addGap(18)
                                                                  .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                                              .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                                                                          .addComponent(btnRearrange, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                                                          .addComponent(velocityLabel))
                                                                              .addComponent(gravityLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                                                  .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                  .addComponent(frictionLabel))
                                                      .addGroup(layout.createSequentialGroup()
                                                                  .addGap(11)
                                                                  .addGroup(layout.createParallelGroup(Alignment.TRAILING)
                                                                              .addComponent(windVectorLabel)
                                                                              .addComponent(playerCoordinates, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))))
                                          .addPreferredGap(ComponentPlacement.RELATED)
                                          .addGroup(layout.createParallelGroup(Alignment.TRAILING)
                                                      .addGroup(layout.createSequentialGroup()
                                                                  .addComponent(calculatorButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                                                  .addGap(18)
                                                                  .addGroup(layout.createParallelGroup(Alignment.TRAILING)
                                                                              .addComponent(obstaclesHeader)
                                                                              .addComponent(approveButton)))
                                                      .addGroup(layout.createSequentialGroup()
                                                                  .addComponent(sliderTextX)
                                                                  .addGap(13)
                                                                  .addComponent(xSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                          .addGap(18)
                                          .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                      .addGroup(layout.createSequentialGroup()
                                                                  .addComponent(hintButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                                                  .addGap(31)
                                                                  .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                                                              .addComponent(goalPostsHeader)
                                                                              .addComponent(sliderTextZ)))
                                                      .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                                  .addGroup(layout.createSequentialGroup()
                                                                              .addComponent(obstacleHeightLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                                              .addGap(18)
                                                                              .addComponent(distanceObstaclesLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                                                  .addGroup(layout.createSequentialGroup()
                                                                              .addComponent(sliderTextY)
                                                                              .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                              .addComponent(ySlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                          .addGap(17)
                                          .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                      .addGroup(layout.createSequentialGroup()
                                                                  .addGap(1)
                                                                  .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                                              .addGroup(layout.createSequentialGroup()
                                                                                          .addComponent(coordinatesOfSecondObstacle)
                                                                                          .addGap(1)
                                                                                          .addComponent(coordinatesOfFirstObstacle))
                                                                              .addComponent(coordinatesOfGoalposts, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                                                  .addPreferredGap(ComponentPlacement.RELATED)
                                                                  .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                                                              .addGroup(layout.createSequentialGroup()
                                                                                          .addComponent(coordinatesOfThirdObstacle)
                                                                                          .addGap(585)
                                                                                          .addComponent(filler1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                              .addComponent(goalpostsHeightLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))
                                                      .addGroup(layout.createSequentialGroup()
                                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                  .addComponent(zSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                          .addContainerGap())
                           );
    layout.linkSize(SwingConstants.VERTICAL, new Component[] {hintButton, calculatorButton, approveButton});
    layout.linkSize(SwingConstants.VERTICAL, new Component[] {ySlider, xSlider});
    layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {hintButton, calculatorButton, approveButton});
    getContentPane().setLayout(layout);
    setSize(1274,640);
    
  }
  
  /**
   * takes the value of the z component of the velocity from the user
   * @param evt slider event that determines velocity
   */
  private void zSliderStateChanged ( javax.swing.event.ChangeEvent evt ) 
  {
    sliderTextZ.setText("Z Axis : " + Integer.toString(zSlider.getValue()));
  }
  
  /**
   * takes the value of the x component of the velocity from the user
   * @param evt slider event that determines velocity
   */
  private void xSliderStateChanged ( javax.swing.event.ChangeEvent evt ) 
  {
    sliderTextX.setText("X Axis : " + Integer.toString(xSlider.getValue()));
  }
  
  /**
   * takes the value of the y component of the velocity from the user
   * @param evt slider event that determines velocity
   */
  private void ySliderStateChanged ( javax.swing.event.ChangeEvent evt ) 
  {
    sliderTextY.setText("Y Axis : " + Integer.toString(ySlider.getValue()));
  }
  
  /**
   * creates and instance of the scientific calculator and opens it 
   * @param evt clicker event on the button
   */
  private void calculatorButtonActionPerformed ( java.awt.event.ActionEvent evt ) 
  {
    Scientific_Calculator calculator = new Scientific_Calculator();
    calculator.setDefaultCloseOperation(Scientific_Calculator.EXIT_ON_CLOSE);
    calculator.setVisible(true);
  }
  
  /**
   * creates and instance of the hints frame and opens it 
   * @param evt clicker event on the button
   */
  private void hintButtonActionPerformed ( java.awt.event.ActionEvent evt ) 
  {
    HintsFrame hintsframe = new HintsFrame( this );
    hintsframe.setVisible ( true );
  }
  
  /**
   * passes the coefficients, contants, locations and velocities to the animation
   * @param evt evt clicker event on the button
   */
  private void approveButtonActionPerformed(java.awt.event.ActionEvent evt) 
  {
    velocity[0] = xSlider.getValue();
    velocity[1] = ySlider.getValue();
    velocity[2] = zSlider.getValue();
    
    game = new Game(cityName, positions, velocity, wind, coefficientOfFriction );
    isFirstTrial = false;
  }
  
  /**
   * sets the city name to the location of the field
   * @param name name of the city
   */
  public void setCityName ( String name ) 
  {
    cityName = name;
    cityNameLabel.setText ( "City: " + cityName );
  }
  
  /**
   * if the user could not score, examines the previous shot and writes a hint
   * @return a string that contains hints for the user
   */
  public String displayHint() 
  {
    // before the first try give necesarray formulas
    if ( isFirstTrial == true ) 
    {
      return "Useful formulas: \n" + "Horizontal distance:     x = (Vx).t \n"
        + "Horizontal velocity:     Vx = Vxo \n" + "Vertical distance:       y = (Vyo).t - (1/2).g.(t^2) \n"
        + "Vertical velocity:       Vy = Vyo - g.t \n"
        + "Maximum height reached:  H = ((Vo^2).sin^2(?)) / (2.g) \n"
        + "Horizontal range:        R = ((Vo^2).sin(2?)) / g \n" + "   Where; \n"
        + "      Vo is the initial velocity, \n" + "      sin ? is the component along y-axis, \n"
        + "      cos ? is the component along x-axis, \n" + "      Vx is the velocity along x-axis, \n"
        + "      Vxo is the initial velocity along x-axis, \n" + "      Vy is the velocity along y-axis, \n"
        + "      Vyo is the initial velocity along y-axis, \n"
        + "      g is the acceleration due to gravity, \n" + "      t is the time taken.";
    }
    
    // after first try analyse player's shot and give helpful hints
    else 
    {
      if ( game.determineRegion() == 1 ) 
      {
        if ( wind[0] < 0 ) 
        {
          return "Consider the wind. It drags the ball to the left of the goalpost.";
        }
        else 
        {
          return "Increase the z-component of the velocity.";
        }
      }
      else if ( game.determineRegion() == 2 ) 
      {
        if ( wind[0] > 0 ) 
        {
          return "Consider the wind. It drags the ball to the right of the goalpost.";
        } else {
          return "Reduce the z-component of the velocity.";
        }
      }
      else if ( game.determineRegion() == 3 ) 
      {
        if ( wind[2] > 0 ) 
        {
          return "Consider the wind. It drags the ball to the upper side of the goalpost.";
        }
        else 
        {
          return "Reduce the y-component of the velocity.";
        }
      }
      else if ( game.determineRegion() == 4 ) 
      {
        if ( wind[0] < 0 && wind[2] > 0 ) 
        {
          return "Consider the wind. It drags the ball to the left-upper side of the goalpost.";
        }
        else if ( wind[0] < 0 && wind[2] <= 0 ) 
        {
          return "Consider the wind. It drags the ball to the left side of the goalpost. "
            + "Also decrease the y-component of the velocity.";
        }
        else if ( wind[0] >= 0 && wind[2] > 0 ) 
        {
          return "Consider the wind. It drags the ball to the upper side of the goalpost. "
            + "Also increase the z-component of the velocity.";
        }
        else if ( wind[0] >= 0 && wind[2] <= 0 ) 
        {
          return "Increase the z-component and decrease the y-component of the velocity.";
        }
      }
      else if ( game.determineRegion() == 5 ) 
      {
        if (wind[0] > 0 && wind[2] > 0) 
        {
          return "Consider the wind. It drags the ball to the right-upper side of the goalpost.";
        }
        else if ( wind[0] > 0 && wind[2] <= 0 ) 
        {
          return "Consider the wind. It drags the ball to the right side of the goalpost. "
            + "Also decrease the y-component of the velocity.";
        }
        else if ( wind[0] <= 0 && wind[2] > 0 ) 
        {
          return "Consider the wind. It drags the ball to the upper side of the goalpost. "
            + "Also decrease the z-component of the velocity.";
        }
        else if ( wind[0] <= 0 && wind[2] <= 0 ) 
        {
          return "Decrease the z-component and y-component of the velocity.";
        }
      }
      else if ( game.determineRegion() == 6 ) 
      {
        return "Increase the y-component of the velocity so that the ball passes over the obstacles.";
      }
    }
    return "";
  }
}