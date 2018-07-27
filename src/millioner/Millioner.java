/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package millioner;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Arslan
 */
public class Millioner extends Application {

   
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException {
        ImageView imgv = new ImageView();
        
        Image back = new Image(new FileInputStream("C:\\Users\\Arslan\\Desktop\\Картинки\\zastavka.jpg"));
        imgv.setImage(back);
        
        Text t = new Text("Welcome to our game!");
        t.setStyle(" -fx-font-size: 20; ");
        t.setFill(Color.BLACK);
        t.setStroke(Color.BLACK);
        t.setTranslateX(150);
        t.setTranslateY(100);
        
        TextField login = new TextField();
        login.setTranslateX(150);
        login.setTranslateY(200);
        login.setMinWidth(100);
        login.setMinHeight(10);
        
            
        Button btn = new Button();
        btn.setText("Start");
        btn.setTranslateX(200);
        btn.setTranslateY(240);
        btn.setMinWidth(50);
        btn.setMinHeight(10);
        
        FileReader fr = new FileReader("Question.txt");
            BufferedReader reader = new BufferedReader(fr);
            ArrayList<String> lines = new ArrayList<String>();
            ArrayList<String> questions = new ArrayList<String>();
            ArrayList<String> corAns = new ArrayList<String>();
            ArrayList<String> fakeAns = new ArrayList<String>();
                    
            String line;
            while((line=reader.readLine())!=null){
                lines.add(line);
            }
                    
            for(int i = 0;i<lines.size();i+=3){
                questions.add(lines.get(i));
            }
            
            for(int i = 1; i<lines.size();i+=3){
                corAns.add(lines.get(i));
            }
            
            for(int i = 2; i<lines.size(); i+=3){
                fakeAns.add(lines.get(i));
            }
            fr.close();
            

        btn.setOnAction(new EventHandler<ActionEvent>() {
            Media sound_sec = new Media(new File("C:\\Users\\Arslan\\Documents\\NetBeansProjects\\Millioner\\src\\sounds\\tikan-e-chasov-rovno-30-sekund.mp3").toURI().toString());
            MediaPlayer media_sec = new MediaPlayer(sound_sec);
                    
            Media uncorrect = new Media(new File("C:\\Users\\Arslan\\Documents\\NetBeansProjects\\Millioner\\src\\sounds\\неправильныйответ.mp3").toURI().toString());
            MediaPlayer media_uncorrect = new MediaPlayer(uncorrect);
            
            boolean But_Clicked=false;
            private final Integer STARTTIME = 30;
            private Timeline t1;
            private Integer sec = STARTTIME;
            int q_num = 0;
            int score = 0;
            Random rand = new Random();
            int CORRECT_ANSWER_POSITION = rand.nextInt(3);
            @Override
            public void handle(ActionEvent event) {
                Stage stage2 = new Stage();
                Group root2 = new Group();
                stage2.setTitle("Start game");
                stage2.setScene(new Scene(root2, 700, 500));
                stage2.setResizable(false);
                
                ImageView imgv2 = new ImageView();
                Image background = null;
                try {
                    background = new Image(new FileInputStream("C:\\Users\\Arslan\\Desktop\\Картинки\\background.jpg"));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Millioner.class.getName()).log(Level.SEVERE, null, ex);
                }
                imgv2.setImage(background);
                
                Rectangle rec = new Rectangle(600, 150);
                rec.setFill(Color.WHITE);
                rec.setStroke(Color.BLACK);
                rec.setArcWidth(20);
                rec.setArcHeight(20);
                rec.setTranslateX(50);
                rec.setTranslateY(80);
                
                
                Text q_number = new Text("Question: " + (q_num+1));
                q_number.setTranslateX(275);
                q_number.setTranslateY(50);
                q_number.setFill(Color.WHITE);
                q_number.setStroke(Color.WHITE);
                q_number.setStyle(" -fx-font-size: 14; ");
                
   
                
                media_sec.play();
       
                String name = login.getText();
 
                Text name_score = new Text(name + ": " + score);
                name_score.setTranslateX(50);
                name_score.setTranslateY(50);
                name_score.setFill(Color.WHITE);
                name_score.setStroke(Color.WHITE);
                name_score.setStyle(" -fx-font-size: 14; ");
                 
                Text question = new Text(questions.get(q_num));
                question.setTranslateX(200);
                question.setTranslateY(150);
                
                Button ans1 = new Button();
                ans1.setMinWidth(150);
                ans1.setMinHeight(50);
                ans1.setTranslateX(50);
                ans1.setTranslateY(250);
                                
                Button ans2 = new Button();
                ans2.setMinWidth(150);
                ans2.setMinHeight(50);
                ans2.setTranslateX(300);
                ans2.setTranslateY(250);
              
                                
                Button ans3 = new Button();
                ans3.setMinWidth(150);
                ans3.setMinHeight(50);
                ans3.setTranslateX(50);
                ans3.setTranslateY(350);
                
                Button ans4 = new Button();
                ans4.setMinWidth(150);
                ans4.setMinHeight(50);
                ans4.setTranslateX(300);
                ans4.setTranslateY(350);
                
                
                ans1.setStyle("-fx-font-size:14;");
                ans2.setStyle("-fx-font-size:14;");
                ans3.setStyle("-fx-font-size:14;");
                ans4.setStyle("-fx-font-size:14;");
                
                Button next = new Button("Next");
                next.setTranslateX(530);
                next.setTranslateY(350);
                next.setStyle(" -fx-background-radius: 20 20 20 20; " );
                next.setVisible(false);
                
                Text timesec = new Text();
                timesec.setText(" ");
                timesec.setTranslateX(550);
                timesec.setTranslateY(50);
                timesec.setStyle(" -fx-font-size: 14; ");
                timesec.setFill(Color.WHITE);
                timesec.setStroke(Color.WHITE);
                
                if (t1 != null) {
                    t1.stop();
                }
                sec = STARTTIME;
                timesec.setText(sec.toString());
                t1 = new Timeline();
                t1.setCycleCount(Timeline.INDEFINITE);
                t1.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                    new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        sec--;
                        timesec.setText(sec.toString());
                        if (sec <= 0) {
                            t1.stop();
                            media_sec.stop();
                            But_Clicked=true;
                            next.setVisible(true);
                            question.setText("Увы!" + name + ", ты не успел. Нажми на кнопку next и попробуй следующий вопрос");
                        }
                    }
                }));
                t1.playFromStart();

                if( CORRECT_ANSWER_POSITION == 0 ){
                    ans1.setText(corAns.get(q_num));
                    
                }
                
                if( CORRECT_ANSWER_POSITION == 1 ){
                    ans2.setText(corAns.get(q_num));
                    
                }
                
                if( CORRECT_ANSWER_POSITION == 2 ){
                    ans3.setText(corAns.get(q_num));
                    
                }
                
                if( CORRECT_ANSWER_POSITION == 3 ){
                    ans4.setText(corAns.get(q_num));
                }
                
                String[] FakeArr = fakeAns.get(q_num).split(";");
                ArrayList<String> FakeArr2 = new ArrayList<>(Arrays.asList(FakeArr));
                System.out.println(FakeArr2.size());
                Collections.shuffle(FakeArr2);
                    if(ans1.getText()==""){
                        ans1.setText(FakeArr2.get(0));
                    }
                    if(ans2.getText()==""){
                        ans2.setText(FakeArr2.get(1));
                    }
                    if(ans3.getText()==""){
                        ans3.setText(FakeArr2.get(2));
                    }
                    if(ans4.getText()==""){
                        ans4.setText(FakeArr2.get(3));
                    }
                
                
                EventHandler<ActionEvent> nextBut = new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event){
                        if(q_num==questions.size()-1){
                            try {
                                media_sec.stop();
                                stage2.close();
                                Stage stage3 = new Stage();
                                Group root3 = new Group();
                                DateFormat datef = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                Date date= new Date();
                                Text text = new Text(name+": "+score+" "+datef.format(date));
                                text.setTranslateX(130);
                                text.setTranslateY(150);
                                stage3.setScene(new Scene(root3, 300, 300));
                                root3.getChildren().add(text);
                                stage3.show();
                                FileReader fr_res = new FileReader("Players.txt");
                                BufferedReader reader_res = new BufferedReader(fr);
                                
                                ArrayList<String> lines_res = new ArrayList<String>();
                                ArrayList<Integer> key_res = new ArrayList<Integer>();
                                
                                TreeMap<Integer, String> results = new TreeMap<Integer, String>();
                                String line_res;
                                while((line_res=reader_res.readLine())!=null){
                                    String[] mass = line_res.split(": ");
                                    lines_res.add(mass[0]);
                                    lines_res.add(mass[1]);
                                }
                                System.out.println(lines_res.get(0)+lines_res.get(1));
                                FileWriter fw = new FileWriter("Players.txt");
                                
                                fw.write(score + ": " + name + " Date " + datef.format(date));
                                fr_res.close();
                                reader_res.close();
                                fw.close();
                                
                            } catch (IOException ex) {
                                Logger.getLogger(Millioner.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            
                        }
                        media_uncorrect.stop();
                        next.setVisible(false);
                        But_Clicked=false;
                        sec = STARTTIME;
                        timesec.setText(sec.toString());
                        t1.playFromStart();
                        media_sec.play();
                        q_num++;
                        ans1.setText("");
                        ans2.setText("");
                        ans3.setText("");
                        ans4.setText("");
                        ans1.setStyle("-fx-font-size:14;");
                        ans2.setStyle("-fx-font-size:14;");
                        ans3.setStyle("-fx-font-size:14;");
                        ans4.setStyle("-fx-font-size:14;");
                        
                        question.setText(questions.get(q_num));
                        q_number.setText("Question: " + (q_num+1));
                        CORRECT_ANSWER_POSITION = rand.nextInt(3);
                        if( CORRECT_ANSWER_POSITION == 0 ){
                            ans1.setText(corAns.get(q_num));

                        }

                        if( CORRECT_ANSWER_POSITION == 1 ){
                            ans2.setText(corAns.get(q_num));

                        }

                        if( CORRECT_ANSWER_POSITION == 2 ){
                            ans3.setText(corAns.get(q_num));

                        }

                        if( CORRECT_ANSWER_POSITION == 3 ){
                            ans4.setText(corAns.get(q_num));
                        }
                        
                        String[] FakeArr = fakeAns.get(q_num).split(";");
                        ArrayList<String> FakeArr2 = new ArrayList<>(Arrays.asList(FakeArr));
                        Collections.shuffle(FakeArr2);
                            if(ans1.getText()==""){
                                ans1.setText(FakeArr2.get(0));
                            }
                            if(ans2.getText()==""){
                                ans2.setText(FakeArr2.get(1));
                            }
                            if(ans3.getText()==""){
                                ans3.setText(FakeArr2.get(2));
                            }
                            if(ans4.getText()==""){
                                ans4.setText(FakeArr2.get(3));
                            }
                    }
                };
                    
                EventHandler<ActionEvent> ev1 = new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event){
                        media_sec.stop();
                        int ans = 0;
                        if(CORRECT_ANSWER_POSITION!=ans && !But_Clicked){
                            ans1.setStyle(" -fx-background-color: red; ");
                            But_Clicked=true;
                            media_uncorrect.play();
                        }
                        if (CORRECT_ANSWER_POSITION==ans && !But_Clicked){
                            ans1.setStyle(" -fx-background-color: lightgreen; ");
                            score++;
                            name_score.setText(name + ": " + score);
                            But_Clicked=true;
                        }
                        timesec.setText("0");
                        next.setVisible(true);
                        t1.stop();
                    }
                };
                EventHandler<ActionEvent> ev2 = new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event){
                        media_sec.stop();
                        int ans = 1;
                        if(CORRECT_ANSWER_POSITION!=ans && !But_Clicked){
                            ans2.setStyle(" -fx-background-color: red; ");
                            But_Clicked=true;
                            media_uncorrect.play();
                        }
                        if(CORRECT_ANSWER_POSITION==ans && !But_Clicked){
                            ans2.setStyle(" -fx-background-color: lightgreen; ");
                            score++;
                            name_score.setText(name + ": " + score);
                            But_Clicked=true;
                        }

                        timesec.setText("0");
                        next.setVisible(true);
                        t1.stop();
                    }
                };
                EventHandler<ActionEvent> ev3 = new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event){
                        media_sec.stop();
                        int ans = 2;
                        if(CORRECT_ANSWER_POSITION!=ans && !But_Clicked){
                            ans3.setStyle(" -fx-background-color: red; ");
                            But_Clicked=true;
                            media_uncorrect.play();
                        }
                        if(CORRECT_ANSWER_POSITION==ans && !But_Clicked){
                            ans3.setStyle(" -fx-background-color: lightgreen; ");
                            score++;
                            name_score.setText(name + ": " + score);
                            But_Clicked=true;
                        }
                        timesec.setText("0");
                        next.setVisible(true);
                        t1.stop();
                    }
                };
                EventHandler<ActionEvent> ev4 = new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event){
                        media_sec.stop();
                        int ans = 3;
                        if(CORRECT_ANSWER_POSITION!=ans && !But_Clicked){
                            ans4.setStyle(" -fx-background-color: red; ");
                            But_Clicked=true;
                            media_uncorrect.play();
                        }
                        if(CORRECT_ANSWER_POSITION==ans && !But_Clicked){
                            ans4.setStyle(" -fx-background-color: lightgreen; ");
                            score++;
                            name_score.setText(name + ": " + score);
                            But_Clicked=true;
                        }
                        timesec.setText("0");
                        next.setVisible(true);
                        t1.stop();
                        
                        
                    }
                };
                
                ans1.setOnAction(ev1);
                ans2.setOnAction(ev2);
                ans3.setOnAction(ev3);
                ans4.setOnAction(ev4);
                next.setOnAction(nextBut);
                
                root2.getChildren().add(imgv2);
                root2.getChildren().add(name_score);
                root2.getChildren().add(ans1);
                root2.getChildren().add(ans2);
                root2.getChildren().add(ans3);
                root2.getChildren().add(ans4);
                root2.getChildren().add(rec);
                root2.getChildren().add(q_number);
                root2.getChildren().add(timesec);
                root2.getChildren().add(next);
                root2.getChildren().add(question);
               
                stage2.show();
                primaryStage.close();
                
                
            }
        });
        
        Group root = new Group();
        root.getChildren().add(imgv);
        root.getChildren().add(btn);
        root.getChildren().add(login);
        root.getChildren().add(t);
        
        Scene scene = new Scene(root, 500, 400);
        
        primaryStage.setTitle("Who wanna be a millionaire?");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
