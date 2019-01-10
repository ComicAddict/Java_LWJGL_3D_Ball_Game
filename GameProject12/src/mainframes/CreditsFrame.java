/*
 * CresitsFrame Class
 * @version: 12.05.2018
 * @author: Mehmet Ömer Eyi
 */
package mainframes;

/**
 * CreditsFrame class
 */
public class CreditsFrame extends javax.swing.JFrame 
{

  //Properties
    // Variables declaration 
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel batuLabel;
    private javax.swing.JLabel informationLabel4;
    private javax.swing.JLabel utkuLabel;
    private javax.swing.JLabel informationLabel6;
    private javax.swing.JLabel creditsTitle;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel informationLabel7;
    private javax.swing.JLabel tolgaLabel;
    private javax.swing.JLabel informationLabel3;
    private javax.swing.JLabel mustafaLabel;
    private javax.swing.JLabel informationLabel2;
    private javax.swing.JLabel omerLabel;
    private javax.swing.JLabel informationLabel;
    private javax.swing.JPanel creditsPanel;

    //Constructors

    /**
     * Creates new form CreditsFrame
     */
    public CreditsFrame()
    {
        initComponents();
    }

    //Methods

    private void initComponents() 
    {

        creditsPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tolgaLabel = new javax.swing.JLabel();
        informationLabel = new javax.swing.JLabel();
        omerLabel = new javax.swing.JLabel();
        informationLabel2 = new javax.swing.JLabel();
        creditsTitle = new javax.swing.JLabel();
        batuLabel = new javax.swing.JLabel();
        mustafaLabel = new javax.swing.JLabel();
        informationLabel4 = new javax.swing.JLabel();
        informationLabel3 = new javax.swing.JLabel();
        utkuLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        informationLabel6 = new javax.swing.JLabel();
        informationLabel7 = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Credits");
        setResizable(false);
        setSize(new java.awt.Dimension(689, 452));
        creditsPanel.setLayout(null);
        backButton.setBackground(new java.awt.Color(0, 0, 0));
        backButton.setFont(new java.awt.Font("Tahoma", 0, 14));
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/cooltext284157147984715.png")));
        backButton.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            /*mouseClicked method
             * @param Mouseevent evt
             */
            public void mouseClicked(java.awt.event.MouseEvent evt) 
            {
                backButtonMouseClicked(evt);
            }
        });

        backButton.addActionListener(new java.awt.event.ActionListener() 
        {
            /*actionPerformed method
             * @param actionPerformed evt
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                backButtonActionPerformed(evt);
            }
        });

        creditsPanel.add(backButton);
        backButton.setBounds(10, 410, 430, 40);

        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("@madeByHumans");
        creditsPanel.add(jLabel1);
        jLabel1.setBounds(530, 420, 120, 30);

        tolgaLabel.setBackground(new java.awt.Color(0, 0, 0));
        tolgaLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        tolgaLabel.setForeground(new java.awt.Color(255, 255, 255));
        tolgaLabel.setText("Tolga Taha Yýldýz...");
        creditsPanel.add(tolgaLabel);
        tolgaLabel.setBounds(20, 160, 190, 30);

        informationLabel.setBackground(new java.awt.Color(0, 0, 0));
        informationLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        informationLabel.setForeground(new java.awt.Color(255, 255, 255));
        informationLabel.setText("Secretary of the MadeByHumans Company");
        creditsPanel.add(informationLabel);
        informationLabel.setBounds(250, 260, 370, 14);

        omerLabel.setBackground(new java.awt.Color(0, 0, 0));
        omerLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        omerLabel.setForeground(new java.awt.Color(255, 255, 255));
        omerLabel.setText("Mehmet Ömer Eyi...");
        creditsPanel.add(omerLabel);
        omerLabel.setBounds(20, 260, 180, 22);

        informationLabel2.setBackground(new java.awt.Color(0, 0, 0));
        informationLabel2.setFont(new java.awt.Font("Tahoma", 0, 18));
        informationLabel2.setForeground(new java.awt.Color(255, 255, 255));
        informationLabel2.setText("Program developer at MadeByHumans Company");
        creditsPanel.add(informationLabel2);
        informationLabel2.setBounds(230, 200, 390, 40);

        creditsTitle.setBackground(new java.awt.Color(0, 0, 0));
        creditsTitle.setFont(new java.awt.Font("Tahoma", 0, 24));
        creditsTitle.setForeground(new java.awt.Color(255, 255, 255));
        creditsTitle.setText("CREDITS");
        creditsPanel.add(creditsTitle);
        creditsTitle.setBounds(250, 40, 230, 29);

        batuLabel.setBackground(new java.awt.Color(0, 0, 0));
        batuLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        batuLabel.setForeground(new java.awt.Color(255, 255, 255));
        batuLabel.setText("Batu Sengezer...");
        creditsPanel.add(batuLabel);
        batuLabel.setBounds(20, 300, 170, 30);

        mustafaLabel.setBackground(new java.awt.Color(0, 0, 0));
        mustafaLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        mustafaLabel.setForeground(new java.awt.Color(255, 255, 255));
        mustafaLabel.setText("Mustafa Furkan Ayaz...");
        creditsPanel.add(mustafaLabel);
        mustafaLabel.setBounds(20, 210, 180, 22);

        informationLabel4.setBackground(new java.awt.Color(0, 0, 0));
        informationLabel4.setFont(new java.awt.Font("Tahoma", 0, 18));
        informationLabel4.setForeground(new java.awt.Color(255, 255, 255));
        informationLabel4.setText("Director of Human Resources at MadeByHumans");
        creditsPanel.add(informationLabel4);
        informationLabel4.setBounds(260, 300, 390, 30);

        informationLabel3.setBackground(new java.awt.Color(0, 0, 0));
        informationLabel3.setFont(new java.awt.Font("Tahoma", 0, 18));
        informationLabel3.setForeground(new java.awt.Color(255, 255, 255));
        informationLabel3.setText("Program developer at MadeByHumans Company");
        creditsPanel.add(informationLabel3);
        informationLabel3.setBounds(200, 160, 390, 22);

        utkuLabel.setBackground(new java.awt.Color(0, 0, 0));
        utkuLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        utkuLabel.setForeground(new java.awt.Color(255, 255, 255));
        utkuLabel.setText("Utku Bilgin...");
        creditsPanel.add(utkuLabel);
        utkuLabel.setBounds(20, 350, 130, 30);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Çaðan Önen ...");
        creditsPanel.add(jLabel2);
        jLabel2.setBounds(20, 90, 160, 60);

        informationLabel6.setBackground(new java.awt.Color(0, 0, 0));
        informationLabel6.setFont(new java.awt.Font("Tahoma", 0, 18));
        informationLabel6.setForeground(new java.awt.Color(255, 255, 255));
        informationLabel6.setText("MadeByHumans CFO from EE department");
        creditsPanel.add(informationLabel6);
        informationLabel6.setBounds(300, 350, 340, 30);

        informationLabel7.setBackground(new java.awt.Color(0, 0, 0));
        informationLabel7.setFont(new java.awt.Font("Tahoma", 0, 18));
        informationLabel7.setForeground(new java.awt.Color(255, 255, 255));
        informationLabel7.setText("Program developer at MadeByHumans Company");
        creditsPanel.add(informationLabel7);
        informationLabel7.setBounds(170, 100, 410, 40);

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/anaekran.jpg")));
        creditsPanel.add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 660, 480);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(creditsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(creditsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                        .addContainerGap())
        );

        pack();
    }
    /*backButtonActionPerformed method
     * @param ActionEvent evt
     */

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        new MainFrame().setVisible(true);
        this.dispose();
    }

    /*backButtonMouseClicked method
     * @param MouseEvent evt
     */
    private void backButtonMouseClicked(java.awt.event.MouseEvent evt)
    {
    }
}
