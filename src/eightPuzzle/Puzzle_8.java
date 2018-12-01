//package eightPuzzle;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashSet;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.Button;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.Pane;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import javafx.stage.Stage;
//
///**
// *
// * @author khaled
// */
//public class Puzzle_8 extends Application {
//    int [] input_array=new int[9];
//      Label [] state ;
//    int solIndex=0;
//    boolean flag=false;
//     Node ROOT;
//     NonHeuristicAlgorithms non = new NonHeuristicAlgorithms();
//     SolutionDetails sol = new SolutionDetails();
//     AStar ast =new AStar();
//    ArrayList<Node> steps;
//
//     
//
//    public void starting_page(Pane starting,  Pane backend){
//    
//    Label l1=new Label("Enter your 8-Puzzle");
//    l1.setTranslateX(10);
//    l1.setTranslateY(30);
//    l1.setStyle("-Fx-base:#FF88F7; -fx-font: 20 arial;");
//    
//    Button btn = new Button("Play");
//
//    
//    
//    TextField []textfield = new TextField[9];
//    
//        for (int i = 0; i < 9; i++) {
//            textfield[i]=new TextField();
//            textfield[i].setPrefWidth(40);
//            textfield[i].setAlignment(Pos.CENTER);
//            textfield[i].setFont(Font.font(null, FontWeight.BOLD, 20));
//        }
//    
//    /* set location of t0*/
//    textfield[0].setTranslateX(20);
//    textfield[0].setTranslateY(80);
//     /* set location of t1*/
//    textfield[1].setTranslateX(80);
//    textfield[1].setTranslateY(80);
//    /* set location of t2*/
//     textfield[2].setTranslateX(140);
//    textfield[2].setTranslateY(80);
//   /* set location of t3*/
//    textfield[3].setTranslateX(20);
//    textfield[3].setTranslateY(150);
//     /* set location of t4*/
//    textfield[4].setTranslateX(80);
//    textfield[4].setTranslateY(150);
//    /* set location of t5*/
//    textfield[5].setTranslateX(140);
//    textfield[5].setTranslateY(150);
//       /* set location of t6*/
//    textfield[6].setTranslateX(20);
//    textfield[6].setTranslateY(220);
//     /* set location of t7*/
//    textfield[7].setTranslateX(80);
//    textfield[7].setTranslateY(220);
//    /* set location of t8*/
//    textfield[8].setTranslateX(140);
//    textfield[8].setTranslateY(220);
//   
//   Image img = new Image(getClass().getResourceAsStream("st.png"));
//   ImageView vv = new ImageView(img);
//   vv.setFitHeight(200);
//   vv.setFitWidth(200);
//   vv.setTranslateX(250);
//   vv.setTranslateY(75);
//   vv.setOnMouseClicked(new EventHandler<MouseEvent>(){
//       
//     @Override
//     public void handle(MouseEvent event) {
//      starting.setVisible(false);
//      backend.setVisible(true);
//           for (int i = 0; i < 9; i++) {
//             input_array[i]=Integer.parseInt(textfield[i].getText().toString());
//              textfield[i].setText("");
//
//        }    
//               
//              drawing(backend,input_array);
//              flag=true;
//               ROOT = new Node(input_array);
//              
//		
//		
//
//    }
//});         
//      starting.getChildren().addAll(vv,l1);
//                 for (int i = 0; i < 9; i++) {
//                     starting.getChildren().add(textfield[i]);
//                 }
//    }
//     void drawing(Pane backend ,int []arr){
//         if(!flag){
//         state=new Label[9];
//        for (int i = 0; i < 9; i++) {
//            state[i]=new Label();
//                        state[i].setFont(Font.font(null, FontWeight.BOLD, 60));
//
//                        backend.getChildren().add(state[i]);
//
//        }
//         }
//                for (int i = 0; i < 9; i++) {
//                     state[i].setText(""+arr[i]);
//                    
//                }
//
//        
//        state[0].setTranslateX(40);
//        state[0].setTranslateY(10);
//        
//        state[1].setTranslateX(140);
//        state[1].setTranslateY(10);
//        
//        state[2].setTranslateX(240);
//        state[2].setTranslateY(10);
//        
//        
//        state[3].setTranslateX(40);
//        state[3].setTranslateY(100);
//        
//        state[4].setTranslateX(140);
//        state[4].setTranslateY(100);
//        
//        state[5].setTranslateX(240);
//        state[5].setTranslateY(100);
//        
//        
//        state[6].setTranslateX(40);
//        state[6].setTranslateY(190);
//        
//        state[7].setTranslateX(140);
//        state[7].setTranslateY(190);
//        
//        state[8].setTranslateX(240);
//        state[8].setTranslateY(190);
//        
//
//              
//    }
//    
//    
//    
//    
//    
//    @Override
//    public void start(Stage primaryStage) {
//
//       Label the_cost=new Label("The Current Cost:  ");
//       the_cost.setTranslateX(230);
//       the_cost.setTranslateY(315);
//       the_cost.setStyle("-Fx-base:#FF88F7; -fx-font: 20 arial;");
//       
//       Label costs=new Label();
//        costs.setTranslateX(410);
//       costs.setTranslateY(315);
//       costs.setStyle("-Fx-base:#FF88F7; -fx-font: 20 arial;");
//
//        
//        Image img = new Image(getClass().getResourceAsStream("p1.jpg"));
//        ImageView vv = new ImageView(img);
//        Pane root = new Pane();
//        Pane starting = new Pane();
//        starting.setVisible(true);
//        Pane backend = new Pane();
//        backend.setVisible(false);
//        
//        
//        
//       Button nextStep=new Button("Next");
//       nextStep.setTranslateX(180);
//       nextStep.setTranslateY(310);
//       
//       Button prevStep=new Button("prev");
//       prevStep.setTranslateX(50);
//       prevStep.setTranslateY(310);
//       
//       
//       
//       Button bfs=new Button("BFS");
//       bfs.setTranslateX(370);
//       bfs.setTranslateY(10);
//       bfs.setFont(Font.font(null, FontWeight.BOLD, 25));
//       
//        Button dfs=new Button("DFS");
//       dfs.setTranslateX(370);
//       dfs.setTranslateY(80);
//       dfs.setFont(Font.font(null, FontWeight.BOLD, 25));
//
//       
//        Button aStar=new Button("A*M");
//       aStar.setTranslateX(370);
//       aStar.setTranslateY(150);
//       aStar.setFont(Font.font(null, FontWeight.BOLD, 23));
//  
//       
//       Button aStarE=new Button("A*E");
//       aStarE.setTranslateX(370);
//       aStarE.setTranslateY(210);
//       aStarE.setFont(Font.font(null, FontWeight.BOLD, 26));
//       
//       
//       
//       bfs.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                drawing(backend, ROOT.puzzle);
//                solIndex=0;          
//                 costs.setText("0");
//                sol = non.BFS(ROOT);
//                steps = sol.getsolutionSteps();
//                 Collections.reverse(steps);
//            }
//        });
//       
//            dfs.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                drawing(backend, ROOT.puzzle);
//                solIndex=0;
//                 costs.setText("0");
//                sol = non.DFS(ROOT);
//                steps = sol.getsolutionSteps();
//                 Collections.reverse(steps);
//            }
//        });
//            
//            aStar.setOnAction(new EventHandler<ActionEvent>() {        
//            @Override
//            public void handle(ActionEvent event) {
//                solIndex=0;
//                drawing(backend, ROOT.puzzle);
//                 costs.setText("0");
//                sol = ast.AStarSearchManhattan(ROOT); 
//                steps = sol.getsolutionSteps();
//                 Collections.reverse(steps);
//            }
//        });
//            
//            aStarE.setOnAction(new EventHandler<ActionEvent>() {        
//            @Override
//            public void handle(ActionEvent event) {
//                solIndex=0;
//                    costs.setText("0");
//                drawing(backend, ROOT.puzzle);
//                sol = ast.AStarSearchEuclid(ROOT); 
//                steps = sol.getsolutionSteps();
//                 Collections.reverse(steps);
//            }
//        });            
//            
//            
//            
//
//            
//          nextStep.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                
//                if (solIndex != steps.size()){
//                    drawing(backend, steps.get(solIndex).puzzle);
//                    costs.setText(""+steps.get(solIndex).level);
//                    solIndex++;
//                } else {
//                    new Alert(AlertType.WARNING, "The Solution is Finished", ButtonType.YES).showAndWait();
//                }
//            }
//            });
//       		
//         prevStep.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                
//                solIndex--;
//                if (solIndex > 0){
//                    drawing(backend, steps.get(solIndex-1).puzzle);
//                    costs.setText(""+steps.get(solIndex-1).level);
//                }else if (solIndex == 0)
//                {
//                    drawing(backend, ROOT.puzzle);
//                    costs.setText("0");
//                }else {
//                    new Alert(AlertType.WARNING, "Warning Start State achieved", ButtonType.YES).showAndWait();
//                    solIndex = 0;
//                }
//
//
//
//            }
//        });
//            
//            
//       
//       
//
//       backend.getChildren().addAll(vv,nextStep,prevStep,bfs,dfs,aStar,aStarE,the_cost,costs);
//
//        
//        starting_page( starting,backend);
//
//        
//        root.getChildren().addAll(starting,backend);
//        Scene scene = new Scene(root, 500, 350);
//        root.setStyle("-fx-background-color:#C39BD3");
//
//        
//        primaryStage.setTitle("8-Puzzle");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        launch(args);
//    }
//    
//}