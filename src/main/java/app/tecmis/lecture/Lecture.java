package app.tecmis.lecture;

import app.tecmis.connection.Config;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx .scene.layout.Pane;

//profile window

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;




//========================

//notice window
import javafx.scene.control.TableView;


//======================


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;


public class Lecture implements Initializable {



    //undergraduate
    @FXML
    private TableView<UndergraduateInformation> Undergraduate_table;

    @FXML
    private TableColumn<UndergraduateInformation, String> col_indexnumber;

    @FXML
    private TableColumn<UndergraduateInformation, String> col_fname;

    @FXML
    private TableColumn<UndergraduateInformation, String> col_lname;

    @FXML
    private TableColumn<UndergraduateInformation, String> col_address;

    @FXML
    private TableColumn<UndergraduateInformation, String> col_email;

    @FXML
    private TableColumn<UndergraduateInformation, String> col_gender;

    @FXML
    private TableColumn<UndergraduateInformation, Date> col_dob;


        @FXML
    public ObservableList<UndergraduateInformation> getUndergraduate() {
        ObservableList<UndergraduateInformation> undergraduateList = FXCollections.observableArrayList();
        Connection conn = Config.getConfig();
        String query = "select * from user WHERE user_type = 'student'";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            UndergraduateInformation undergraduate;

            while (rs.next()) {
                undergraduate = new UndergraduateInformation(
                        rs.getString("userId"),
                        rs.getString("f_name"),
                        rs.getString("l_name"),
                        rs.getString("email"),
                        rs.getString("gender"),
                        rs.getDate("bod"),
                        rs.getString("address")
                );

                undergraduateList.add(undergraduate);
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

        return undergraduateList;
    }

    public void showUndergraduate() {
        ObservableList<UndergraduateInformation> list = getUndergraduate();

        col_indexnumber.setCellValueFactory(new PropertyValueFactory<UndergraduateInformation,String>("undergraduateId"));
        col_fname.setCellValueFactory(new PropertyValueFactory<UndergraduateInformation,String>("undergraduateFname"));
        col_address.setCellValueFactory(new PropertyValueFactory<UndergraduateInformation,String>("undergraduateAddress"));
        col_gender.setCellValueFactory(new PropertyValueFactory<UndergraduateInformation,String>("undergraduateGender"));
        col_dob.setCellValueFactory(new PropertyValueFactory<UndergraduateInformation,Date>("undergraduateDob"));
        col_email.setCellValueFactory(new PropertyValueFactory<UndergraduateInformation,String>("undergraduateEmail"));
        col_lname.setCellValueFactory(new PropertyValueFactory<UndergraduateInformation,String>("undergraduateLname"));

        Undergraduate_table.setItems(list);
    }















    //=======================================


//profile
    @FXML
    private TextField user_name_textfeild;
    @FXML
    private TextField password_text_feild;
    @FXML
    private ImageView change_photo_icon;

    @FXML
    private Button edit_profile_btn;

    @FXML
    private Label information_lebal;

    @FXML
    private Label security_lebal;


    @FXML
    private TextField first_name_textfield;

    @FXML
    private TextField last_name_textfield;

    @FXML
    private TextField contact_number_textfield;


    @FXML
    private TextField gmail_textfield;

    @FXML
    private Button save_changes_butten;

    @FXML
    private Button edit_infor_btn;

    @FXML
    private Button edit_btn;


    @FXML
    private AnchorPane profile_part2_infor_panel;

    @FXML
    private AnchorPane profile_window_inside_part1;

    @FXML
    private AnchorPane profile_part2_Securitiy_panel;
    @FXML
    void saveLecBtn(ActionEvent event) {
        lecUpdate();
    }
    @FXML
    void editMode(ActionEvent event) {
        first_name_textfield.setEditable(true);
        last_name_textfield.setEditable(true);
        contact_number_textfield.setEditable(true);
        gmail_textfield.setEditable(true);

    }




    @FXML
    void information_lebal_click(MouseEvent event) {

        if(event.getSource() == information_lebal) {
            profile_part2_infor_panel.setVisible(true);
            profile_part2_Securitiy_panel.setVisible(false);

        } else if (event.getSource() == security_lebal) {

            profile_part2_infor_panel.setVisible(false);
            profile_part2_Securitiy_panel.setVisible(true);



        }
    }





    //===================

    //notice

    @FXML
    private TableColumn<NoticeInformation,String> col_Description;

    @FXML
    private TableColumn<NoticeInformation, Date> col_data;

    @FXML
    private TableColumn<NoticeInformation, String> col_notice_id;

    @FXML
    private TableColumn<NoticeInformation, String> col_notice_title;

    @FXML
    private TableView<NoticeInformation> notice_table;



    @FXML
    private Label lbl_notice_title;

    @FXML
    private Label lbl_Description;

    @FXML
    private Label lbl_date;


    @FXML

    public ObservableList<NoticeInformation> getNotice(){

        ObservableList<NoticeInformation> NoticeList = FXCollections.observableArrayList();
        Connection conn = Config.getConfig();
        String query = "SELECT * FROM notice";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            NoticeInformation notice;
            while (rs.next()){
                notice = new NoticeInformation(rs.getString("notice_id"),rs.getString("description"),rs.getDate("date"),rs.getString("notice_title"));
                NoticeList.add(notice);
            }


        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
            return NoticeList;
    }
    @FXML
    public  void showNotice(){
        ObservableList<NoticeInformation> List = getNotice();
          col_notice_id.setCellValueFactory(new PropertyValueFactory<NoticeInformation,String>("noticeId"));
        col_data.setCellValueFactory(new PropertyValueFactory<NoticeInformation,Date>("Date"));
        col_notice_title.setCellValueFactory(new PropertyValueFactory<NoticeInformation,String>("noticeTitle"));

        notice_table.setItems(List);



    }

    @FXML
    void handleNotice(MouseEvent event) {


        NoticeInformation notice = notice_table.getSelectionModel().getSelectedItem();
        lbl_notice_title.setText("" + notice.getNoticeTitle());
        lbl_date.setText(""+notice.getDate());
        lbl_Description.setText(""+notice.getDescription());


    }






    //=========================
    String username = "LEC001";
    String password ="pass1";

    //course




    //=================================================


    @FXML
    private ImageView logout_photo;



    @FXML
    private AnchorPane undergraduate_window;
    @FXML
    private AnchorPane notice_window;
    @FXML
    private AnchorPane grade_window;
    @FXML
    private AnchorPane exam_window;
    @FXML
    private AnchorPane eligibility_window;
    @FXML
    private AnchorPane attenfance_window;



    @FXML
    private Pane back_btn_pane;

    @FXML
    private AnchorPane courses_window;

    @FXML
    private AnchorPane profile_window;


    @FXML
    private AnchorPane all_profile_window;

    @FXML
    private ImageView attendeance_photo;

    @FXML
    private ImageView courses;

    @FXML
    private ImageView eligibility_photo;

    @FXML
    private ImageView exam_mark;

    @FXML
    private ImageView grade_gpa_photo;

    @FXML
    private AnchorPane main_panel;

    @FXML
    private ImageView notice_photo;

    @FXML
    private ImageView profile;

    @FXML
    private ImageView undergraduate_photo;
    @FXML
    private Button go_back_btn;

    @FXML
    private Label welcome_Name;

     //String username = LoginController.lecTg;



    @FXML
    void handleAllprofile(MouseEvent event) {
        if (event.getSource() == profile) {

            all_profile_window.setVisible(false);
            profile_window.setVisible(true);

            courses_window.setVisible(false);
            exam_window.setVisible(false);
            undergraduate_window.setVisible(false);
            eligibility_window.setVisible(false);
            grade_window.setVisible(false);
            attenfance_window.setVisible(false);
            notice_window.setVisible(false);



        }
        else if (event.getSource() == courses) {
            all_profile_window.setVisible(false);
            courses_window.setVisible(true);

            profile_window.setVisible(false);
            exam_window.setVisible(false);
            undergraduate_window.setVisible(false);
            eligibility_window.setVisible(false);
            grade_window.setVisible(false);
            attenfance_window.setVisible(false);
            notice_window.setVisible(false);

        }
        else if (event.getSource() == exam_mark) {
            all_profile_window.setVisible(false);
            exam_window.setVisible(true);

            undergraduate_window.setVisible(false);
            eligibility_window.setVisible(false);
            grade_window.setVisible(false);
            attenfance_window.setVisible(false);
            notice_window.setVisible(false);
            profile_window.setVisible(false);
            courses_window.setVisible(false);



        }

        else if (event.getSource() == undergraduate_photo) {
            all_profile_window.setVisible(false);
            undergraduate_window.setVisible(true);


            eligibility_window.setVisible(false);
            grade_window.setVisible(false);
            attenfance_window.setVisible(false);
            notice_window.setVisible(false);
            profile_window.setVisible(false);
            courses_window.setVisible(false);
            exam_window.setVisible(false);



        }
        else if (event.getSource() == eligibility_photo) {
            all_profile_window.setVisible(false);
            eligibility_window.setVisible(true);


            undergraduate_window.setVisible(false);
            grade_window.setVisible(false);
            attenfance_window.setVisible(false);
            notice_window.setVisible(false);
            profile_window.setVisible(false);
            courses_window.setVisible(false);
            exam_window.setVisible(false);



        }

        else if (event.getSource() == grade_gpa_photo) {
            all_profile_window.setVisible(false);
            grade_window.setVisible(true);


            eligibility_window.setVisible(false);
            undergraduate_window.setVisible(false);
            attenfance_window.setVisible(false);
            notice_window.setVisible(false);
            profile_window.setVisible(false);
            courses_window.setVisible(false);
            exam_window.setVisible(false);



        }

        else if (event.getSource() == notice_photo) {
            all_profile_window.setVisible(false);
            notice_window.setVisible(true);


            eligibility_window.setVisible(false);
            undergraduate_window.setVisible(false);
            attenfance_window.setVisible(false);
            grade_window.setVisible(false);
            profile_window.setVisible(false);
            courses_window.setVisible(false);
            exam_window.setVisible(false);



        }
        else if (event.getSource() == attendeance_photo) {
            all_profile_window.setVisible(false);
            attenfance_window.setVisible(true);


            eligibility_window.setVisible(false);
            undergraduate_window.setVisible(false);
            grade_window.setVisible(false);
            notice_window.setVisible(false);
            profile_window.setVisible(false);
            courses_window.setVisible(false);
            exam_window.setVisible(false);



        }





    }


    @FXML
    void backtoALLprofile(ActionEvent event) {



            all_profile_window.setVisible(true);
            profile_window.setVisible(false);
            courses_window.setVisible(false);
            exam_window.setVisible(false);
            undergraduate_window.setVisible(false);
            eligibility_window.setVisible(false);
            grade_window.setVisible(false);
            attenfance_window.setVisible(false);
            notice_window.setVisible(false);

    }

    public ObservableList<LectureInformation> getLecture(){
        ObservableList<LectureInformation> lecList = FXCollections.observableArrayList();
        Connection conn = Config.getConfig();
        String sql = "SELECT * FROM lecture l " +
                     "JOIN user u ON l.lecture_id = u.userId " +
                     "LEFT JOIN user_contact uc ON u.userId = uc.userId " +
                     "INNER JOIN department d ON d.dep_id = l.dep_id " +
                     "WHERE u.userId = '"+username+"'";
        Statement stmt = null;
        ResultSet rs = null;
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            LectureInformation lecDetails;
            while(rs.next()){
                lecDetails = new LectureInformation(rs.getString("userId"),rs.getString("nic"),
                        rs.getString("f_name"),
                        rs.getString("l_name"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("gender"),
                        rs.getDate("bod"),
                        rs.getString("contact_no"),
                        rs.getString("position"),
                        rs.getString("dep_name")
                );
                lecList.add(lecDetails);
                System.out.println("user id " + rs.getString("f_name"));
            }
        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return lecList;
    }
    public void showLecDetails(){
        ObservableList<LectureInformation> lecList = getLecture();
        LectureInformation lec = lecList.get(0);
        first_name_textfield.setText(lec.getLecFname());
        last_name_textfield.setText(lec.getLecLname());
        contact_number_textfield.setText(lec.getLecContactNo());
        gmail_textfield.setText(lec.getLecEmail());
    }

    public void setLecName(){
        ObservableList<LectureInformation> lecList = getLecture();
        LectureInformation lec = lecList.get(0);
        welcome_Name.setText(lec.getLecFullName());
    }
    public void lecUpdate(){
        Connection conn = Config.getConfig();


        String lecFName = first_name_textfield.getText();
        String lecLName = last_name_textfield.getText();
        String leccontactNo = contact_number_textfield.getText();
        String lecEmail = gmail_textfield.getText();


//        String[] nameParts = lecFullName.split(" ");
//        String first_name = nameParts[0];
//        String last_name = nameParts.length > 1 ? nameParts[1] : "";

//        String ucUpdateSql = "UPDATE user_contact SET contact_no=? WHERE userId=?";
//        String lecUpdateSql = "UPDATE lecture SET position=?, dep_id=? WHERE lecture_id=?";
//        String userUpdateSql = "UPDATE user SET f_name = ?,l_name = ?, nic = ?, address = ?,email = ?,gender = ?,bod = ?, password = ? WHERE userId = ?";
               String userUpdateSql = "UPDATE user SET f_name = ? WHERE userId = '"+username+"'";
              String  userUpdateSql2 = "UPDATE user SET l_name = ? WHERE userId = '"+username+"'";
                String  userUpdateSql3 = "UPDATE user_contact SET contact_no  = ? WHERE userId = '"+username+"'";
                String  userUpdateSql4 = "UPDATE user SET email = ? WHERE userId = '"+username+"'";


        try{

//            PreparedStatement ucPs = conn.prepareStatement(ucUpdateSql);
//            ucPs.setString(1, lecContactNo);
//            ucPs.setString(2, lecId);
//            ucPs.executeUpdate();
//
//            PreparedStatement lecUpdateStmt = conn.prepareStatement(lecUpdateSql);
//            lecUpdateStmt.setString(1, lecPosition);
//            lecUpdateStmt.setString(2, ld);
//            lecUpdateStmt.setString(3, lecId);
//            lecUpdateStmt.executeUpdate();

            PreparedStatement userPs = conn.prepareStatement(userUpdateSql);
            userPs.setString(1, lecFName);

            PreparedStatement leclast = conn.prepareStatement(userUpdateSql2);
            leclast.setString(1, lecLName); // changed 2 -> 1

            PreparedStatement leccon = conn.prepareStatement(userUpdateSql3);
            leccon.setString(1, leccontactNo); // changed 3 -> 1

            PreparedStatement lecmail = conn.prepareStatement(userUpdateSql4);
            lecmail.setString(1, lecEmail); // changed 4 -> 1







//            userPs.setString(2, last_name);
//            userPs.setString(3, lecNIC);
//            userPs.setString(4, lecAddress);
//            userPs.setString(5, lecEmail);
//            userPs.setString(6, lecGender);
//            userPs.setString(7, lecBod.toString());
//            userPs.setString(8, lecPassword);
//            userPs.setString(9, lecId);

            String sql = "UPDATE user SET f_name = ?, l_name = ?, email = ? WHERE userId = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, lecFName);
            ps.setString(2, lecLName);
            ps.setString(3, lecEmail);
            ps.setString(4, username);
            ps.executeUpdate();

//            userPs.executeUpdate();
//            leclast.executeUpdate();
//            leccon.executeUpdate();
//            lecmail.executeUpdate();

            Alert updatedAlert = new Alert(Alert.AlertType.INFORMATION);
            updatedAlert.setTitle("Lecture Updated");
            updatedAlert.setHeaderText(null);
            updatedAlert.setContentText("Lecture updated successfully!");
            updatedAlert.showAndWait();
        } catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }

        setLecName();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        getLecture();
        showLecDetails();
        setLecName();
        showNotice();
        showUndergraduate();

    }

}
