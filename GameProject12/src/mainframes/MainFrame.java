/*
 *MainFrame Class
 * @version: 12.05.2018
 * @author: Mehmet �mer Eyi
 */
package mainframes;

import worldmap.WorldMap;

/**
 * MainFrame Class
 */
public class MainFrame extends javax.swing.JFrame 
{

    // Variables declaration 

    private javax.swing.JButton creditsButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton howToPlayButton;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel madeByhumansLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JButton worldMapsButton;

    //Constructors
    /**
     * Creates new form MainFrame
     */
    public MainFrame() 
    {
        initComponents();
    }
  //Methods
  /*
     * initComponents method
     * this method initializes the components
     */

    private void initComponents() 
    {

        jPanelMain = new javax.swing.JPanel();
        howToPlayButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        creditsButton = new javax.swing.JButton();
        worldMapsButton = new javax.swing.JButton();
        madeByhumansLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        iconLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MainMenu");
        setResizable(false);
        jPanelMain.setLayout(null);
        howToPlayButton.setBackground(new java.awt.Color(0, 0, 0));
        howToPlayButton.setFont(new java.awt.Font("Times New Roman", 0, 18));
        howToPlayButton.setForeground(new java.awt.Color(255, 255, 255));
        howToPlayButton
                .setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/cooltext284155797942012.png")));
        howToPlayButton.addActionListener(new java.awt.event.ActionListener() {
            /*actionPerformed method
             * @param ActionEvent evt
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                howToPlayButtonActionPerformed(evt);
            }
        });

        jPanelMain.add(howToPlayButton);
        howToPlayButton.setBounds(340, 190, 260, 50);
        //Formating exitbutton
        exitButton.setBackground(new java.awt.Color(0, 0, 0));
        exitButton.setFont(new java.awt.Font("Tahoma", 0, 18));
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/cooltext284157078004441.png")));
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            /*mouseClicked method
             * @param mouseEvent evt
             */
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                exitButtonMouseClicked(evt);
            }
        });

        jPanelMain.add(exitButton);
        exitButton.setBounds(60, 550, 73, 23);

        creditsButton.setBackground(new java.awt.Color(0, 0, 0));
        creditsButton.setFont(new java.awt.Font("Times New Roman", 0, 18));
        creditsButton.setForeground(new java.awt.Color(255, 255, 255));
        creditsButton
                .setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/cooltext284155851907568.png")));
        creditsButton.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            /*mouseClicked method
             * @param MouseEvent evt
             */
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                creditsButtonMouseClicked(evt);
            }
        }
        );

        creditsButton.addActionListener(new java.awt.event.ActionListener() 
        {
            /*backButtonActionPerformed method
             * @param ActionEvent evt
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                creditsButtonActionPerformed(evt);
            }
        });

        jPanelMain.add(creditsButton);
        creditsButton.setBounds(390, 350, 170, 40);

        worldMapsButton.setBackground(new java.awt.Color(0, 0, 0));
        worldMapsButton.setFont(new java.awt.Font("Times New Roman", 0, 18));
        worldMapsButton.setForeground(new java.awt.Color(255, 255, 255));
        worldMapsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/cooltext284155877189994.png")));
        worldMapsButton.addActionListener(new java.awt.event.ActionListener() 
        {
            /*actionPerformed method
             * @param ActionEvent evt
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                worldMapsButtonActionPerformed(evt);
            }
        });
        jPanelMain.add(worldMapsButton);
        worldMapsButton.setBounds(310, 270, 310, 50);
        //formating  madeByhumns title
        madeByhumansLabel.setFont(new java.awt.Font("Verdana", 3, 12));
        madeByhumansLabel.setForeground(new java.awt.Color(102, 255, 255));
        madeByhumansLabel.setText("@madeByHumans");
        madeByhumansLabel.setToolTipText("");
        jPanelMain.add(madeByhumansLabel);
        madeByhumansLabel.setBounds(760, 550, 130, 60);
        //formating the title label
        titleLabel.setBackground(new java.awt.Color(0, 0, 0));
        titleLabel.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 48));
        titleLabel.setForeground(new java.awt.Color(51, 204, 0));
        titleLabel.setText("P.HY.S.I.C.S");
        jPanelMain.add(titleLabel);
        titleLabel.setBounds(260, 70, 410, 100);

        iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/anaekran.jpg")));
        jPanelMain.add(iconLabel);
        iconLabel.setBounds(0, 0, 900, 620);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE));

        pack();
    }

    /*howToPlayActionPerformed method
     * This method opens HowToPlayFrame
     * @param ActionEvent evt
     */
    private void howToPlayButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        HowToPlayFrame howTo = new HowToPlayFrame();
        howTo.setVisible(true);
        this.dispose();
    }

    /*wolrdMapsButtonActionPerformed method
     * This method opens worldMaps frame
     * @param ActionEvent evt
     */
    private void worldMapsButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        WorldMap map = new WorldMap();
        map.setSize(1050, 550);
        map.setVisible(true);
        this.dispose();
    }

    /*creditsButtonMouseClicked method
     * This method opens CreditsFrame
     * @param MouseEvent evt
     */
    private void creditsButtonMouseClicked(java.awt.event.MouseEvent evt) 
    {
        new CreditsFrame().setVisible(true);;
        this.dispose();

    }

    /*exitButtonMouseClicked method
     * This method quits the game
     * @param MouseEvent evt
     */
    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt)
    {
        System.exit(0);
    }

    private void creditsButtonActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    /**
     * Main method
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) 
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) 
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) 
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainFrame().setVisible(true);
            }
        }
        ); 
    }
}