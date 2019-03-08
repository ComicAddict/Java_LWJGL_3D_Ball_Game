package level.properties;

import engineTester.Game;


public class JFrame extends javax.swing.JFrame {

    // Constants 
    private static final float GRAVITY = 9.81f;
    private static final float WIDTH_OF_FIELD = 40f; //meters
    private static final float HEIGHT_OF_FIELD = 40f; //meters
    private static final float HEIGHT_OF_OBSTACLES = 3f; //meters
    private static final float HEIGHT_OF_GOALPOSTS = 2.5f; //meters
    private static final float WIDTH_OF_OBSTACLES = 7.5f; //meters
    
    
    // Properties
    protected Game game;
    protected String cityName;
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
    
    

    // Constructor
    public JFrame() 
    {
        initComponents();
        
        gravityLabel.setText ( "Gravity: " + GRAVITY );
        //set obstacle height and goalposts height label
        obstacleHeightLabel.setText ( "Height of Obstacles: " + HEIGHT_OF_OBSTACLES + " m " );
        goalpostsHeightLabel.setText ( "Height of Goalposts: " + HEIGHT_OF_GOALPOSTS + " m " );
        
        //determine coefficient of friction
        coefficientOfFriction =  ( float ) Math.random();
        
        //determine coordinates of the player
        positions[0] = -Math.round( random ( HEIGHT_OF_FIELD / 8,  HEIGHT_OF_FIELD / 2 ) );
        positions[1] = -Math.round ( random ( ( -1 ) *  WIDTH_OF_FIELD / 2, WIDTH_OF_FIELD / 2 ) ) ;
        
        // set coordinates of the player label
        playerCoordinates.setText( "Coordinates of the player (x,z): " + "( " + positions[0] + ", " + positions[1] + " )" );
        
        // set coordinates of the goalposts label 
        coordinatesOfGoalposts.setText ( "Coordinates of the Goalpost (x,z): " + "( " + 0 + ", " + -1 * WIDTH_OF_FIELD / 2 + " )" );
        
        // determine coordinates of the obstacles
        // randomise x coordinates
        positions[2] = Math.round ( placeObstaclesX());
        positions[4] = Math.round ( placeObstaclesX());
        positions[6] = Math.round ( placeObstaclesX());
        
        // randomise z coordinates
        positions[3] = Math.round ( random ( ( -3 ) * HEIGHT_OF_FIELD / 8,  0 ) );
        positions[5] = Math.round ( random ( ( -3 ) * HEIGHT_OF_FIELD / 8,  0 ) );
        positions[7] = Math.round ( random ( ( -3 ) * HEIGHT_OF_FIELD / 8,  0 ) );
        
        //set obstacle distance label
        distanceObstaclesLabel.setText ( "Coordinates of the Obstacles ( x,z ): " ); 
        coordinatesOfFirstObstacle.setText ( "( " + positions[2] + ", " + positions[3] + " )");
        coordinatesOfSecondObstacle.setText ( "( " + positions[4] + ", " + positions[5] + " )");
        coordinatesOfThirdObstacle.setText ( "( " + positions[6] + ", " + positions[6] + " )");
        
        // determine wind vector
        // later it will be editted and it will change according to location
        wind[0] = random ( -12, 12 );
        wind[1] = random ( -5, 5 );
        wind[2] = random ( -5, 5 );
    }
    
            
    /**
     * determines the coordinates of the obstacles and making them near to the player in x axis
     * @return x coordinates of the obstacles
     */
    private float placeObstaclesX () {
        if ( positions[0] >=  WIDTH_OF_FIELD / 4 )
            return random ( 0, positions[1] );
        
        else if ( positions[0] < 0 && ( -1 ) * positions[0] >=  WIDTH_OF_FIELD  / 4 )
            return random ( positions[0], 0 );
        
        else 
            return random ( positions[0] - WIDTH_OF_FIELD / 4 , positions[0] + WIDTH_OF_FIELD / 4 );         
    }
    
    /**
     * genrates a random number in a specified range
     * @param lowerBoundry lower boundry of the range
     * @param upperBoundry upper boundry of the range
     * @return a random integer in that range
     **/
    private float random ( float lowerBoundry, float upperBoundry  ) {
        float range;
        range = upperBoundry - lowerBoundry;
        return ( float )( Math.random() * range ) + lowerBoundry;
    }

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        ySlider = new javax.swing.JSlider(-40,40,0);
        zSlider = new javax.swing.JSlider(-40,40,0);
        xSlider = new javax.swing.JSlider(-40,40,0);
        infoLabel = new javax.swing.JLabel();
        gravityLabel = new javax.swing.JLabel();
        obstacleHeightLabel = new javax.swing.JLabel();
        goalpostsHeightLabel = new javax.swing.JLabel();
        distanceObstaclesLabel = new javax.swing.JLabel();
        hintButton = new javax.swing.JButton();
        calculatorButton = new javax.swing.JButton();
        playerCoordinates = new javax.swing.JLabel();
        velocityLabel = new javax.swing.JLabel();
        sliderTextX = new javax.swing.JLabel();
        sliderTextY = new javax.swing.JLabel();
        sliderTextZ = new javax.swing.JLabel();
        windLabel = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        coordinatesOfGoalposts = new javax.swing.JLabel();
        approveButton = new javax.swing.JButton();
        coordinatesOfFirstObstacle = new javax.swing.JLabel();
        coordinatesOfSecondObstacle = new javax.swing.JLabel();
        coordinatesOfThirdObstacle = new javax.swing.JLabel();
        cityNameLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        wind = new float[3];
        positions = new float[10];
        velocity = new float[3];

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ySliderStateChanged(evt);
            }
        });

        zSlider.setMajorTickSpacing(1);
        zSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                zSliderStateChanged(evt);
            }
        });

        xSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                xSliderStateChanged(evt);
            }
        });

        infoLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        infoLabel.setText("General Information");

        gravityLabel.setText("Gravity: 9.81");

        obstacleHeightLabel.setText("Height of Obstacles: 3.0 m ");

        goalpostsHeightLabel.setText("Height of Goalpost ");

        distanceObstaclesLabel.setText("Coordinates of the obstacles (x,z) :  ");

        hintButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        hintButton.setText("HINT");
        hintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hintButtonActionPerformed(evt);
            }
        });

        calculatorButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        calculatorButton.setText("CALCULATOR");
        calculatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculatorButtonActionPerformed(evt);
            }
        });

        playerCoordinates.setText("Coordinate of the Player ( x,z ): ( 0,0 ) ");

        velocityLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        velocityLabel.setText("3D Velocity Vector");

        sliderTextX.setText("X Axis : 0");

        sliderTextY.setText("Y Axis : 0");

        sliderTextZ.setText("Z Axis : 0");

        windLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        windLabel.setText("Wind Vector");

        coordinatesOfGoalposts.setText("Coordinates of the Goalposts ( x,z ): ( 0,0 )");

        approveButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        approveButton.setText("APPROVE");
        approveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveButtonActionPerformed(evt);
            }
        });

        coordinatesOfFirstObstacle.setText("jLabel2");

        coordinatesOfSecondObstacle.setText("jLabel2");

        coordinatesOfThirdObstacle.setText("jLabel4");

        cityNameLabel.setText("City: HAGIA SOPHIA");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Obstacles");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Goalposts");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(obstacleHeightLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(distanceObstaclesLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(coordinatesOfSecondObstacle)
                            .addComponent(coordinatesOfFirstObstacle)
                            .addComponent(coordinatesOfThirdObstacle)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(goalpostsHeightLabel)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(206, 206, 206)
                            .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(181, 181, 181))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ySlider, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(xSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(zSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(37, 37, 37)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(sliderTextZ)
                        .addGap(184, 184, 184))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(sliderTextX)
                        .addGap(186, 186, 186))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(velocityLabel)
                        .addGap(118, 118, 118))))
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(coordinatesOfGoalposts)
                    .addComponent(playerCoordinates)
                    .addComponent(infoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(windLabel)
                .addGap(156, 156, 156))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(cityNameLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(gravityLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(hintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(calculatorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(approveButton)
                        .addGap(158, 158, 158))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(sliderTextY)
                        .addGap(185, 185, 185))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {approveButton, calculatorButton, hintButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(windLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cityNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gravityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerCoordinates, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(59, 59, 59))
                    .addComponent(obstacleHeightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(distanceObstaclesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(velocityLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coordinatesOfFirstObstacle)
                    .addComponent(sliderTextX))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coordinatesOfSecondObstacle)
                    .addComponent(xSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coordinatesOfThirdObstacle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderTextY)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(goalpostsHeightLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sliderTextZ))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(zSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(coordinatesOfGoalposts, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(hintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(calculatorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(approveButton))))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {xSlider, ySlider});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {approveButton, calculatorButton, hintButton});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void zSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_zSliderStateChanged
        sliderTextZ.setText("Z Axis : " + Integer.toString(zSlider.getValue()));
    }//GEN-LAST:event_zSliderStateChanged

    private void xSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_xSliderStateChanged
        sliderTextX.setText("X Axis : " + Integer.toString(xSlider.getValue()));
    }//GEN-LAST:event_xSliderStateChanged

    private void ySliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ySliderStateChanged
        sliderTextY.setText("Y Axis : " + Integer.toString(ySlider.getValue()));
    }//GEN-LAST:event_ySliderStateChanged

    private void calculatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculatorButtonActionPerformed
        Scientific_Calculator calculator = new Scientific_Calculator();
        calculator.setDefaultCloseOperation ( Scientific_Calculator.EXIT_ON_CLOSE );
        calculator.setVisible(true);
    }//GEN-LAST:event_calculatorButtonActionPerformed

    private void hintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hintButtonActionPerformed
       
        
    }//GEN-LAST:event_hintButtonActionPerformed

    private void approveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveButtonActionPerformed
       
       velocity[0] = xSlider.getValue();
       velocity[1] = ySlider.getValue();
       velocity[2] = zSlider.getValue();
       
       game = new Game(cityName, positions, velocity);
       System.out.println(game.isCollidingWithObstacles());
       System.out.println(game.isGoal());
       System.out.println(game.isOut());
       
    }//GEN-LAST:event_approveButtonActionPerformed

    public void setCityName(String name) {
        cityName = name;
        cityNameLabel.setText( "City: " + cityName );
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel obstacleHeightLabel;
    private javax.swing.JLabel playerCoordinates;
    private javax.swing.JLabel sliderTextX;
    private javax.swing.JLabel sliderTextY;
    private javax.swing.JLabel sliderTextZ;
    private javax.swing.JLabel velocityLabel;
    private javax.swing.JLabel windLabel;
    private javax.swing.JSlider xSlider;
    private javax.swing.JSlider ySlider;
    private javax.swing.JSlider zSlider;
    // End of variables declaration//GEN-END:variables
}
