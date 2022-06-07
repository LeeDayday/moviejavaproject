import javax.swing.*;

import ListDAO.Connectionz;
import ListVO.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.*;

public class MemberPage extends JFrame {
   private JFrame mainFrame;
   private JPanel mainPanel;
   private JLabel MemberLabel = new JLabel("ȸ��");
   private JButton searchButton;
   private JButton listButton;
   private JTextArea movieSearchArea;
   private JTextArea movieListArea;
   private JTextArea otherMovieListArea;
   
   private JLabel searchSignLabel;
   private JPanel searchPagePanel;
   private JTextField [] searchField;
   private JButton movieSearchButton;
   private String [] searchCondition = {"��ȭ ���� : ", "���� �̸� : ", "��� �̸� : ", "��        �� :"}; 
   private JLabel [] conditionLabel;
   private JButton reservationButton;
   private JButton backButton;
   
   private JLabel listSignLabel;
   private JPanel listPanel;
   private JLabel idLabel;
   private JTextField idField;
   private JButton inquiringButton;
   private JButton deleteButton;
   private JButton changeMovieButton;
   private JButton changeTimeButton;
   
   private Connection con = Connectionz.getConnection();
   private Statement st;
   private PreparedStatement pst;
   private ResultSet result;
   
   public MemberPage() {
      mainFrame = new JFrame();
      mainPanel = new JPanel();
      searchButton = new JButton("��ȭ �˻� �� ����");
      listButton = new JButton("���� ���� ����");
      searchSignLabel = new JLabel("��ȭ ������ �Է��ϼ���. (��ĭ ����)");
      searchPagePanel = new JPanel();
      conditionLabel = new JLabel[4];
      searchField = new JTextField[4];
      movieSearchButton = new JButton("�˻�");
      reservationButton = new JButton("��ȭ ����");
      backButton = new JButton("�ڷΰ���");
      
      listSignLabel = new JLabel("���̵� �Է��� �� ��ȸ ��ư�� ��������.");
      listPanel = new JPanel();
      idLabel = new JLabel("��ȸ�� ���̵� : ");
      idField = new JTextField();
      inquiringButton = new JButton("��ȸ");
      deleteButton = new JButton("���� ���");
      changeMovieButton = new JButton("���� ��ȭ ����");
      changeTimeButton = new JButton("���� �ð� ����");
      
      movieSearchArea = new JTextArea();
      movieListArea = new JTextArea();
      otherMovieListArea = new JTextArea();
      
      showMemberPageMain();
   }

   public MemberPage(String Uname) {
         MemberLabel.setText("ȸ�� "+Uname);
   }
   
   private void showMemberPageMain() {
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainFrame.setTitle("Member Page");
      mainFrame.setSize(900, 650);
      mainFrame.setLocationRelativeTo(null);
      mainFrame.setLayout(new BorderLayout());
      
      printMemberMainPage();
      mainFrame.add(mainPanel, BorderLayout.CENTER);
      
      showSearchPage();
      showListPage();
      
      mainFrame.setVisible(true);
   }
   
   private void printMemberMainPage() {
      mainPanel.setLayout(null);
      mainPanel.setPreferredSize(new Dimension(900,650));
      
      searchButton.setSize(300, 50);
      searchButton.setLocation(290, 100);
      
      listButton.setSize(300, 50);
      listButton.setLocation(290, 170);
      
      mainPanel.add(searchButton);
      mainPanel.add(listButton);
      
      mainPanel.setVisible(true);
   }
   
   private void showSearchPage() { // ��ȭ �˻� �κ� �����ִ� ������ 
      searchButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            mainPanel.setVisible(false);
            printSearchPage();
            mainFrame.add(searchPagePanel);
            mainFrame.repaint();
         }
      }); 
         
   }
   
   private void printSearchPage() { // ��ȭ �˻�
      searchPagePanel.setPreferredSize(new Dimension(900, 650));
      searchPagePanel.setLayout(null);
      searchPagePanel.setOpaque(false);
      
      backButton.setBounds(780, 10, 90, 20);
      
      for (int i=0;i<searchCondition.length;i++) {
         conditionLabel[i] = new JLabel(searchCondition[i]);
         conditionLabel[i].setSize(350, 20);
      }
      
      conditionLabel[0].setLocation(15, 35);
      conditionLabel[1].setLocation(15, 60);
      conditionLabel[2].setLocation(15, 85);
      conditionLabel[3].setLocation(15, 110);
      
      for (int i=0;i<searchField.length;i++) {
         searchField[i] = new JTextField();
         searchField[i].setSize(400, 20);
      }
      
      searchField[0].setLocation(120, 35);
      searchField[1].setLocation(120, 60);
      searchField[2].setLocation(120, 85);
      searchField[3].setLocation(120, 110);
      
      reservationButton.setBounds(650, 110, 100, 20);
      
      movieSearchButton.setBounds(540, 110, 100, 20);
      
      movieSearchArea.setBounds(20, 150, 840, 400);
      
      searchSignLabel.setSize(300, 20);
      searchSignLabel.setLocation(10, 10);
      searchPagePanel.add(searchSignLabel);
      for (int i=0;i<conditionLabel.length;i++) {
         searchPagePanel.add(conditionLabel[i]);
         searchPagePanel.add(searchField[i]);
      }
      searchPagePanel.add(movieSearchButton);
      searchPagePanel.add(backButton);
      searchPagePanel.add(movieSearchArea);
      searchPagePanel.add(reservationButton);
      
      movieSearchButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            movieSearchArea.setText("");
            movieSearchArea.append(String.format("%s\t %s\t %s\t %s\t %s\t %s\t %s\t %s\t %s\n", "��ȭ ��ȣ", "��ȭ ����", "�󿵽ð�", "�������", "����", "���", "�帣", "����", "������"));
            selectMovieListFromDataBase(searchField[0].getText(), searchField[1].getText(), searchField[2].getText(), searchField[3].getText());
         }
      });
      reservationButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	   printReservation();
          }
      });
      searchPagePanel.setVisible(true);
      
      backButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            for (int i=0;i<searchField.length;i++) {
               searchField[i].setText("");
            }
            searchPagePanel.setVisible(false);
            mainPanel.setVisible(true);
            mainFrame.repaint();
         }
      });
   }
   
   private void printReservation() {
      
      JLabel signLabel = new JLabel("���������� ������ ��ȭ��ȣ�� �Է��ϼ���.");
      String [] information = {"���̵� : ", "��ȭ��ȣ : "}; 
      JTextField [] textField = new JTextField[2];
      JLabel [] textLabel = new JLabel[2];
      JButton resMiniButton = new JButton("����");
      
     
      
   
            JFrame resFrame = new JFrame();
            resFrame.setTitle("Reservation");
            resFrame.setSize(400, 200);
            resFrame.setLocationRelativeTo(null);
            resFrame.setLayout(new BorderLayout());
            
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(400, 300));
            panel.setLayout(null);
            
            signLabel.setBounds(10, 10, 300, 20);
            
            for (int i=0;i<information.length;i++) {
               textLabel[i] = new JLabel(information[i]);
               textLabel[i].setSize(100, 20);
            }
            
            textLabel[0].setLocation(10, 50);
            textLabel[1].setLocation(10, 80);
            
            for (int i=0;i<textField.length;i++) {
               textField[i] = new JTextField();
               textField[i].setSize(200, 20);
            }
            
            textField[0].setLocation(100, 50);
            textField[1].setLocation(100, 80);
            
            resMiniButton.setBounds(310, 80, 60, 20);
            
            panel.add(signLabel);
            for (int i=0;i<information.length;i++) {
               panel.add(textLabel[i]);
               panel.add(textField[i]);
            }
            panel.add(resMiniButton);
            resFrame.add(panel, BorderLayout.CENTER);
            resFrame.setVisible(true);
            
            resMiniButton.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  insertMemberListToDataBase(textField[1].getText(), textField[0].getText());
               }
            });
       
   }

   
   private void showListPage() { // ���� ���� ��ȸ ȭ�� �����ִ� �Լ�
      listButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            printListPage();
            mainPanel.setVisible(false);
            mainFrame.add(listPanel);
         }
      }); 
   }

   private void printListPage() {
      listPanel.setPreferredSize(new Dimension(900, 650));
      listPanel.setLayout(null);
      
      listSignLabel.setBounds(10, 5, 300, 20);
      backButton.setBounds(780, 10, 90, 20);
      
      idLabel.setBounds(10, 30, 120, 20);
      idField.setBounds(130, 30, 150, 20);
      inquiringButton.setBounds(300, 30, 80, 20);
      deleteButton.setBounds(10, 80, 150, 20);
      changeMovieButton.setBounds(170, 80, 150, 20);
      changeTimeButton.setBounds(330, 80, 150, 20);
      
      movieListArea.setBounds(20, 120, 840, 220); // ���� ������ �����ִ� textArea
      otherMovieListArea.setBounds(20, 360, 840, 220); // ��ȭ �ٲٴ� ��ư, �ð� �ٲٴ� ��ư ������ �ٸ� ��ȭ ������ ������ִ� textArea
      
      listPanel.add(listSignLabel);
      listPanel.add(idLabel);
      listPanel.add(idField);
      listPanel.add(inquiringButton);
      listPanel.add(deleteButton);
      listPanel.add(changeMovieButton);
      listPanel.add(changeTimeButton);
      listPanel.add(backButton);
      listPanel.add(movieListArea);
      listPanel.add(otherMovieListArea);
      
      listPanel.setVisible(true);
      
      inquiringButton.addActionListener(new ActionListener() { // ��ȸ ��ư�� ���� ���
         public void actionPerformed(ActionEvent e) {
            initTextArea(movieListArea);
            initTextArea(otherMovieListArea);
            movieListArea.append(String.format("%s\t %s\t %s\t %s\t %s\n", "�� ��ȣ", "��ȭ ����", "�� ��¥", "�¼� ��ȣ", "�Ǹ� ����"));
            otherMovieListArea.append(String.format("%s\t %s\t %s\t %s\t %s\t %s\t %s\t %s\t %s\n", "��ȭ ��ȣ", "��ȭ ����", "�󿵽ð�", "�������", "����", "���", "�帣", "����", "������"));
            selectMembersMovieList(idField.getText());
            addOtherFunction(idField.getText()); // ��ȸ�� �� ������ ���������� ��ȸ�� �Ǿ�� �ٸ� ����� �����ǵ��� ���߿� �ڵ� �߰� �ؾ��� (���ǹ��� �߰��ϸ� ��)
         }
      });
      
      backButton.addActionListener(new ActionListener() { // �ڷ� ���� ��ư�� ���� ���
         public void actionPerformed(ActionEvent e) {
            idField.setText("");
            listPanel.setVisible(false);
            mainPanel.setVisible(true);
            mainFrame.repaint();
         }
      });
   }
   private void initTextArea(JTextArea textArea) {
      textArea.setText("");
   }
   
   private void addOtherFunction(String id) { 
      
      deleteButton.addActionListener(new ActionListener() { // ���� ���
         public void actionPerformed(ActionEvent e) {
            deleteMovie(id);
         }
      });
      
      changeMovieButton.addActionListener(new ActionListener() { // �ٸ� ��ȭ�� 
         public void actionPerformed(ActionEvent e) {
            changeMovie();
         }
      });
      
      changeTimeButton.addActionListener(new ActionListener() { // �ٸ� �ð����
         public void actionPerformed(ActionEvent e) {
            changeMovie();
         }
      });
   }
   
   private void deleteMovie(String id) { // ���� ���
      JFrame resFrame = new JFrame();
      JLabel signLabel = new JLabel("����� ���� ��ȣ�� �Է��ϼ���.");
      JLabel textLabel = new JLabel("���� ��ȣ : ");
      JTextField textField = new JTextField();
      JButton deleteMiniButton = new JButton("���� ���");
      
      resFrame.setTitle("Delete Movie");
      resFrame.setSize(340, 170);
      resFrame.setLocationRelativeTo(null);
      resFrame.setLayout(new BorderLayout());
      
      JPanel panel = new JPanel();
      panel.setPreferredSize(new Dimension(400, 300));
      panel.setLayout(null);
      
      signLabel.setBounds(10, 10, 300, 20);
      textLabel.setBounds(10, 50, 100, 20);
      textField.setBounds(80, 50, 120, 20);
      
      deleteMiniButton.setBounds(210, 50, 100, 20);
      
      panel.add(signLabel);
      panel.add(textLabel);
      panel.add(textField);
      panel.add(deleteMiniButton);

      resFrame.add(panel, BorderLayout.CENTER);
      resFrame.setVisible(true);
      
      deleteMiniButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            deleteMemberMovie(textField.getText(), id);
         }
      });
   }
   
   private void changeMovie() { // ��ȭ�� ��ȭ �ð� �ٲٱ�
      JFrame resFrame = new JFrame();
      JLabel signLabel = new JLabel("���� ��ȭ ��ȣ�� ���ϴ� ��ȭ ��ȣ�� �Է��ϼ���.");
      JLabel currentLabel = new JLabel("����    ��ȣ : ");
      JLabel textLabel = new JLabel("���ϴ� ��ȣ : ");
      JTextField [] textField = new JTextField[2];
      JButton changeMiniButton = new JButton("���� ����");
      
      resFrame.setTitle("Change Movie");
      resFrame.setSize(400, 230);
      resFrame.setLocationRelativeTo(null);
      resFrame.setLayout(new BorderLayout());
      
      JPanel panel = new JPanel();
      panel.setPreferredSize(new Dimension(400, 300));
      panel.setLayout(null);
      
      
      for (int i=0;i<textField.length;i++) {
         textField[i] = new JTextField();
         textField[i].setSize(180, 20);
      }
      
      textField[0].setLocation(100, 50);
      textField[1].setLocation(100, 80);
      
      signLabel.setBounds(10, 10, 300, 20);
      currentLabel.setBounds(10, 50, 100, 20);
      textLabel.setBounds(10, 80, 100, 20);
      
      changeMiniButton.setBounds(290, 80, 90, 20);
      
      panel.add(signLabel);
      panel.add(currentLabel);
      panel.add(textLabel);
      for (int i=0;i<2;i++) {
         panel.add(textField[i]);
      }
      panel.add(changeMiniButton);

      resFrame.add(panel, BorderLayout.CENTER);
      resFrame.setVisible(true);
      
      changeMiniButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            selectOtherMovieList(textField[0].getText());
         }
      });
   }
   
   
   private void selectMovieListFromDataBase(String title, String dir, String actor, String genre) {
        try {
            st = con.createStatement();
            String query;
       
            if (title.length() == 0 && dir.length() == 0 && actor.length() == 0 && genre.length() == 0) {
               query = "SELECT * FROM Movie";
            }
            else {
               query = "SELECT * FROM Movie WHERE ";
            }
            
            if (title.length() != 0) {
               query += String.format("Movie_title='%s' AND ", title);
            }
            if (dir.length() != 0) {
               query += String.format("Movie_dir='%s' AND ",  dir);
            }
            if (actor.length() != 0) {
               query += String.format("Movie_actor='%s' AND ", actor);
            }
            if (genre.length() != 0) {
               query += String.format("Movie_genre='%s'", genre);
            }
            
            if (query.substring(query.length() - 4).equals("AND ")) {
               query = query.substring(0, query.length() - 5);
            }

            result = st.executeQuery(query);
            while(result.next()) {
               movieSearchArea.append(String.format("%s\t %s\t %s\t %s\t %s\t %s\t %s\t %s\t %s\n", 
                     Integer.toString(result.getInt(1)), result.getString(2), Integer.toString(result.getInt(3)), result.getString(4),
                           result.getString(5), result.getString(6), result.getString(7), result.getString(8), result.getString(9)));
            }
            
         }catch(SQLException e) {
            System.out.println("����");
         }
   }
   
   private void insertMemberListToDataBase(String memberid, String movieid) { // �����ϱ�
	      try {
	         String sql = String.format("INSERT INTO Ticket(Schedule_id, Seat_id, Ticket_print, Ticket_price, Ticket_saleprice) VALUES('%s', 3, true, 10000, 7000)", movieid);
	         String sql2 = String.format("INSERT INTO Reservation(Res_payment, Res_cost, Res_paid, Member_id, Res_date) VALUES('cash', 7000, true, '%s', '2021-10-01')", memberid);
	         st.executeUpdate(sql);
	         st.executeUpdate(sql2);
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	   }
	   }
   private void selectMembersMovieList(String id) {
      try {
         st = con.createStatement();
         String sql = String.format("select m.Member_id, m.Member_name, mo.Movie_title, sc.Schedule_date, sc.Schedule_id, t.Seat_id, t.Ticket_saleprice from member m, reservation r, ticket t, movie mo, schedule sc where m.member_id = r.member_id and r.Res_id = t.Res_id and t.Schedule_id = sc.Schedule_id and sc.Movie_id = mo.Movie_id and m.Member_id = '%s'", id);
         result = st.executeQuery(sql);
         
         while(result.next()) {
            movieListArea.append(String.format("%s\t %s\t %s\t %s\t %s\n", 
                  Integer.toString(result.getInt(5)), result.getString(3),
                  result.getString(4), Integer.toString(result.getInt(6)), Integer.toString(result.getInt(7))));

         }
         
      }catch(SQLException e) {
         System.out.println("����");
      }
   }
   
   private void selectOtherMovieList(String id) {
      try {
         st = con.createStatement();
         String query = String.format("SELECT * FROM Movie WHERE Movie_id != '%s'", id);
         result = st.executeQuery(query);
         
         while(result.next()) {
            otherMovieListArea.append(String.format("%s\t %s\t %s\t %s\t %s\t %s\t %s\t %s\t %s\n", 
                  Integer.toString(result.getInt(1)), result.getString(2), Integer.toString(result.getInt(3)), result.getString(4),
                        result.getString(5), result.getString(6), result.getString(7), result.getString(8), result.getString(9)));

         }
         
      }catch(SQLException e) {
         System.out.println("����");
      }
   }
   
   private void deleteMemberMovie(String movie, String member) {
      try {
         String sql = String.format("DELETE FROM Reservation WHERE res_id = '%s'", member);
         pst = con.prepareStatement(sql);
         pst.executeUpdate();
         
      } catch(SQLException e) {
         System.out.println("����"+e);
      }
   }
   
   
   
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               new MemberPage();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   
}