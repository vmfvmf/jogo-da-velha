/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OldGame;

/**
 *
 * @author vi
 */
public class Jogada{
        private int x;
        private int y;

        public Jogada(int x, int y){
            this.x = x;
            this.y = y;
        }
        /**
         * @return the x
         */
        public int getX() {
            return x;
        }

        /**
         * @param x the x to set
         */
        public void setJogada(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * @return the y
         */
        public int getY() {
            return y;
        }
        
        public String tipoJogada(){
            if((x == 0 && y == 0) || (x == 0 && y == 2) ||
                    (x == 2 && y == 0) || (x == 2 && y == 2))
                return "canto";
            else if(x == 1 && y == 1)
                return "centro";
            else return "lado";
        }
        
    }
