/**
 * Created by yuval_edelman on 3/25/2015.
 */

    import java.util.Random;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;

    public class Life {
        static Random rand = new Random();
        private  int current[][]=new int [0][0];
        private  int next[][]=new int [0][0];

        Life(int row,int col){//constructor
            current=new int[col][row];//current life
            setLife(current);
            next=new int[col][row];//next life...
            arryCopy(current,next);//copy cur to next

        }

        public void setLife (int[][]matrix){//set new life
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    matrix[i][j]=randInt();
                }
            }

        }

        public  int randInt() {//randomize the life cell
            int randomNum = rand.nextInt((1 - 0) + 1) + 0;
            return randomNum;
        }

        public void arryCopy(int a[][],int b[][]){// copy matrix a to b
            for(int i=0;i<a.length;i++){
                for(int j=0;j<a[0].length;j++){
                    b[i][j]=a[i][j];
                }
            }
        }

        public void print(){//print the life matrix
            StringBuilder str1 = new StringBuilder();
            for( int i = 0; i < current.length; i++ ) {
                for( int j = 0; j < current[ i ].length; j++ ) {
                    if(current[i][j]==1){
                        str1 = str1.append( '+' );
                    }else{
                        str1 = str1.append( '-' );
                    }
                }
                str1 = str1.append( '\n' );
            }
            JOptionPane.showMessageDialog(null, new JLabel( "<html><pre>" + str1.toString()));
        }

        public void printSecond(){
            StringBuilder str1 = new StringBuilder();
            for( int i = 0; i < next.length; i++ ) {
                for( int j = 0; j < next[ i ].length; j++ ) {
                    if(next[i][j]==1){
                        str1 = str1.append( '+' );
                    }else{
                        str1 = str1.append( '-' );
                    }
                }
                str1 = str1.append( '\n' );
            }
            JOptionPane.showMessageDialog(null, new JLabel( "<html><pre>" + str1.toString()));
            arryCopy(next,current);//make the current life matrix to be the next life matrix after the new life
        }

        public int countLife(int i,int j){//count the life
            int count=0;
            if (i!=0 && j!=0 && i!= current.length-1 && j!=current[0].length-1){//all is good
                if(current[i-1][j-1]==1){
                    count=count+1;
                }
                if(current[i][j-1]==1){
                    count=count+1;
                }
                if(current[i+1][j-1]==1){
                    count=count+1;
                }
                if(current[i+1][j]==1){
                    count=count+1;
                }
                if(current[i+1][j+1]==1){
                    count=count+1;
                }
                if(current[i][j+1]==1){
                    count=count+1;
                }
                if(current[i-1][j+1]==1){
                    count=count+1;
                }
                if(current[i-1][j]==1){
                    count=count+1;
                }
                return count;
            }
            if(i==0 && j==0){//left top corner
                if(current[i+1][j]==1){
                    count=count+1;
                }
                if(current[i+1][j+1]==1){
                    count=count+1;
                }
                if(current[i][j+1]==1){
                    count=count+1;
                }
                return count;
            }
            if(i==current.length-1 && j==0){//left bottom corner
                if(current[i-1][j]==1){
                    count=count+1;
                }
                if(current[i-1][j+1]==1){
                    count=count+1;
                }
                if(current[i][j+1]==1){
                    count=count+1;
                }
                return count;
            }
            if(i==0 && j==current[0].length-1){//right top corner
                if(current[i+1][j]==1){
                    count=count+1;
                }
                if(current[i+1][j-1]==1){
                    count=count+1;
                }
                if(current[i][j-1]==1){
                    count=count+1;
                }
                return count;
            }

            if(i==current.length-1 && j== current[0].length-1){//right bottom corner
                if(current[i][j-1]==1){
                    count=count+1;
                }
                if(current[i-1][j-1]==1){
                    count=count+1;
                }
                if(current[i-1][j]==1){
                    count=count+1;
                }
                return count;
            }
            if(i!=0 && j==0){//left side
                if(current[i+1][j]==1){
                    count=count+1;
                }
                if(current[i+1][j+1]==1){
                    count=count+1;
                }
                if(current[i][j+1]==1){
                    count=count+1;
                }
                if(current[i-1][j+1]==1){
                    count=count+1;
                }
                if(current[i-1][j]==1){
                    count=count+1;
                }
                return count;
            }
            if(i!=0 && j==current[0].length-1){//right side
                if(current[i-1][j]==1){
                    count=count+1;
                }
                if(current[i+1][j]==1){
                    count=count+1;
                }
                if(current[i][j-1]==1){
                    count=count+1;
                }
                if(current[i-1][j-1]==1){
                    count=count+1;
                }
                if(current[i+1][j-1]==1){
                    count=count+1;
                }
                return count;
            }
            if(i==0 && j!=current[0].length-1){//top row!
                if(current[i][j-1]==1){
                    count=count+1;
                }
                if(current[i+1][j-1]==1){
                    count=count+1;
                }
                if(current[i+1][j]==1){
                    count=count+1;
                }
                if(current[i+1][j+1]==1){
                    count=count+1;
                }
                if(current[i][j+1]==1){
                    count=count+1;
                }
                return count;
            }
            if(i==current.length-1 && j!=0){//bottom
                if(current[i-1][j-1]==1){
                    count=count+1;
                }
                if(current[i][j-1]==1){
                    count=count+1;
                }
                if(current[i-1][j]==1){
                    count=count+1;
                }
                if(current[i-1][j+1]==1){
                    count=count+1;
                }
                if(current[i][j+1]==1){
                    count=count+1;
                }
                return count;
            }

            return count;
        }

        public void setNewLife(){
            int count=0;
            for(int i=0;i<current.length;i++){
                for(int j=0;j<current[0].length;j++){
                    count=countLife(i,j);
                    if(count==3 && current[i][j]==0){//new life
                        next[i][j]=1;
                    }
                    if(count<2 && current[i][j]==1){//death
                        next[i][j]=0;
                    }
                    if(count>3 && current[i][j]==1){////death
                        next[i][j]=0;

                    }
                }
            }
        }

    }


