package br.inatel.EC205.model;

import java.util.ArrayList;

/**
 *
 * @author amantedouglas
 */
public class Escalation {
    
    public String name;
    /* 4-4-2 
    4-5-1  
    5-3-2  
    3-4-3   
    */
    public String function;
    /* 4-4-2 - Normal
    4-5-1  - Warm Game
    5-3-2  - Total Defense
    3-4-3  - Total Atack
    */
    
    //public String []escalationOficialName = new String[16];
    public ArrayList<String> escalationOficialName = new ArrayList<>();
    public ArrayList<Integer> escalationOficialNumberShirt = new ArrayList<>();
    public Players []  player = new Players[39];
    public Teams []teams = new Teams[16]; 
    public GeneratePatterns generatePatterns;
    
    public void  Escalation(){
        /*int i;
        for(i=0;i<escalationOficialName.length;i++){
            escalationOficialName[i] = new String();
        }*/
    }

    public ArrayList<String> getEscalationOficialName() {
        return this.escalationOficialName;
    }

    public void setEscalationOficialName(ArrayList<String> escalationOficialName) {
        this.escalationOficialName = escalationOficialName;
    }
    
    public ArrayList<Integer> getEscalationOficialNumberShirt(){
        return this.escalationOficialNumberShirt;
    }
    
    public void setEscalationOficialNumberShirt(ArrayList<Integer> escalationOficialNumberShirt){
        this.escalationOficialNumberShirt = escalationOficialNumberShirt;
    }
    
    
    public void setGeneratePatterns(GeneratePatterns generatepatterns){
        this.generatePatterns = generatepatterns;
    }
    
         
    
    public void bestChoicePlayer(String name){ // ERRO7
        /*int i;

        for(i=0; i<escalationOficialName.length; i++){
            escalationOficialName[i] = new String();
        }*/
        
        if(escalationOficialName != null && !escalationOficialName.contains(name))
                escalationOficialName.add(name);
    }
    
    public void SelectionTactic(int teamAux, Teams[] teams){
        
        int j;
        int i; 
        double goalByGameDone;
        double goalByGameTaken;
        int game = 15;
        String team = "";
        
        if(teamAux==1){
            team = "Origin";
        }
        if(teamAux==2){
            team = "Cabrid";
        }
        if(teamAux==3){
            team = "Chuchuq";
        }
        if(teamAux==4){
            team = "Nowin";
        }
        if(teamAux==5){
            team = "Mowqilio";
        }
        if(teamAux==6){
            team = "Powlif";
        }
        if(teamAux==7){
            team = "Bakapowho";
        }
        if(teamAux==8){
            team = "Choolsa";
        }
        if(teamAux==9){
            team = "Paraloppy";
        }
        if(teamAux==10){
            team = "Gabbywol";
        }
        if(teamAux==11){
            team = "Pahol";
        }
        if(teamAux==12){
            team = "Panatilows";
        }
        if(teamAux==13){
            team = "Hollo";
        }
        if(teamAux==14){
            team = "Excheloh";
        }
        if(teamAux==15){
            team = "Kalakazi";
        }
        
        
        
        for(i=0;i<teams.length;i++){
            
            if(teams[i].getNames().equalsIgnoreCase(team)){
                int goalsScored = teams[i].getGoalsScored();

                int goalsConceded = teams[i].getGoalsConceded();
                int defealts = teams[i].getDefealts();
                int victories = teams[i].getVictories();
                int draws = teams[i].getDraws();
                double numberConsideration;
                int totalGameForMath;
                double ProbabilityConsideration;
                int relevation = 0;
                
                //Probability of the team do goal or taken
                goalByGameDone = goalsScored/game;
                goalByGameTaken = goalsConceded/game;
                numberConsideration = ((victories*0.5)+(draws*0.1)+(defealts*0.4));
                totalGameForMath = victories+draws+defealts;
                ProbabilityConsideration = numberConsideration/totalGameForMath;
                
                
                //if PROBABILITYCONSIDERATION > 0.2 = LITTLE DRAWS 

                //if PROBABILITYCONSIDERATION > 0.5 = victories or defealts 

                if(ProbabilityConsideration<0.2){
                    //Draws muito
                    relevation = 1;
                }

                else if((ProbabilityConsideration>0.2)&&(ProbabilityConsideration<0.5)) {

                    //Oscilation much
                    relevation = 2;
                }

                else{
                    //Victories or defealts *All or nothing
                    relevation = 2;
                }
                
                if((goalByGameDone>=1)&&(relevation==2)) //I have play with more defensores
                {
                    
                
                    name = "4-5-1";

                    System.out.printf("%s",this.getName());
                    function = "Warm Game";
                    generatePatterns.Choose(1,2,1,1,3,0,1,1,1);
                    
                    if(goalByGameTaken>=1){
                        name = "5-3-2";

                        System.out.printf("%s",this.getName());
                        function = "Total defense";
                        generatePatterns.Choose(1, 3, 1, 1, 2, 1, 0, 0, 2);
                }

                else{
                    
                    name = "4-4-2";
                    System.out.printf("%s",this.getName());
                
                    function = "Normal";
                    generatePatterns.Choose(1,2,1,1,2,2,0,0,2);
                    if(goalByGameTaken>=2){
                        name = "3-4-3";

                        System.out.printf("%s",this.getName());
                        function = "Total atack";
                        generatePatterns.Choose(1, 3, 0, 0, 2, 2, 1, 1, 1);
                    }
                }
                }
                
            }   

        }
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
    
    
    
}
