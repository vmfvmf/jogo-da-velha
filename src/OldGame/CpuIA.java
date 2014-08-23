/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OldGame;

import java.util.Random;

/**
 *
 * @author vi
 */
public class CpuIA {

    boolean cpuComeca, primeiraJogadaCentro = true;
    GameCpu g;
    int jogadas = 0;
    Jogada jogadaProtetora;

    public CpuIA(GameCpu g) {
        this.g = g;
        jogadaProtetora = new Jogada(0, 0);
    }

    public Jogada cpuTurn() {
        Jogada j;
        switch (jogadas) {
            case 0: // primeira jogada
                jogadas++;
                primeiraJogadaCentro = new Random().nextInt(2) == 1;
                if (cpuComeca) {
                    return primeiraJogadaCentro
                            ? play("centro") : // centro
                            play("canto");
                } else {
                    return !g.checkPosition(new Jogada(1, 1))
                            ? play("canto")
                            : play("centro");
                }
            case 1: // segunda jogada
                jogadas++;
                j = jogadaLados();
                if(j.getX() != -1 && j.getY() != -1){
                    return j;
                }
                if (cpuComeca) {
                    if (primeiraJogadaCentro) {
                        String next = cantoOposto(g.getUltimaJogada());
                        return playCheck(next).getX() != -1
                                ? play(next) : playCheck("canto");
                    } else {
                        return playCheck("canto");
                    }
                } else {
                    j = checkWin(g.getPlayer().getTag(), g.getEnemy().getTag());
                    if (j.getX() != -1 && j.getY() != -1) {
                        return j;
                    }
                    return g.tabuleiro[1][1] == g.getEnemy().getTag() ? playCheck("lado")
                            : playCheck("canto");
                }
            case 2: // terceira em diante
                //jogadas++;
                j = checkWin(g.getEnemy().getTag(), g.getPlayer().getTag());
                if (j.getX() != -1 && j.getY() != -1) {
                    return j;
                }
                j = checkWin(g.getPlayer().getTag(), g.getEnemy().getTag());
                if (j.getX() != -1 && j.getY() != -1) {
                    return j;
                }
                
                j.setJogada(1, 1);
                if (g.checkPosition(j)) {
                    return j;
                }
                //j = playCheck("canto");
                return play("free");//j.getX() != -1 && j.getY() != -1 ? playCheck("lado") : j;
        }
        return null;
    }

    public Jogada playCheck(String jogada) {
        Jogada j;
        int count = 0;
        do {
            j = play(jogada);
            count++;
        } while (!g.checkPosition(j) && count < 20);
        return count < 20 ? j : new Jogada(-1, -1);
    }

    /**
     *
     * @param jogada
     * @return
     */
    public Jogada play(String jogada) {
        Random rand = new Random();
        int n;
        switch (jogada) {
            case "centro":
                return new Jogada(1, 1);
            case "lado":
                n = rand.nextInt(4);
                return n == 0 ? new Jogada(0, 1)
                        : n == 1 ? new Jogada(1, 0)
                        : n == 2 ? new Jogada(1, 2) : new Jogada(2, 1);
            case "canto":
                n = rand.nextInt(4);
                return n == 0 ? new Jogada(0, 0)
                        : n == 1 ? new Jogada(0, 2)
                        : n == 2 ? new Jogada(2, 0) : new Jogada(2, 2);
            case "cantoInferiorE":
                return new Jogada(2, 0);
            case "cantoInferiorD":
                return new Jogada(2, 2);
            case "cantoSupE":
                return new Jogada(0, 0);
            case "cantoSupD":
                return new Jogada(0, 2);
            case "jPro":
                return jogadaProtetora;
            case "diagonalE":
                return g.checkPosition(new Jogada(0, 0)) ? new Jogada(0, 0)
                        : g.checkPosition(new Jogada(1, 1)) ? new Jogada(1, 1)
                        : new Jogada(2, 2);
            case "diagonalD":
                return g.checkPosition(new Jogada(0, 2)) ? new Jogada(0, 2)
                        : g.checkPosition(new Jogada(1, 1)) ? new Jogada(1, 1)
                        : new Jogada(2, 0);
            case "free":
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        if(g.getTabuleiro()[i][j] == 'a')
                            return new Jogada(i, j);
                    }
                }
        }
        return null;
    }

    private String cantoOposto(Jogada ultimaJogada) {
        switch (ultimaJogada.getX()) {
            case 0:
                return ultimaJogada.getY() >= 1
                        ? "cantoInferiorE" : "cantoInferiorD";
            case 1:
                return ultimaJogada.getY() >= 1
                        ? "cantoSupE" : "cantoInferiorD";
            case 2:
                return ultimaJogada.getY() >= 1
                        ? "cantoSupE" : "cantoSupD";

        }
        return "";
    }

    private Jogada checkWin(char pWin, char pLose) {
        int count;
        for (int i = 0; i < 3; i++) {
            count = 0;
            count += g.getTabuleiro()[i][0] == pWin ? 1
                    : g.getTabuleiro()[i][0] == pLose ? -1 : 0;
            count += g.getTabuleiro()[i][1] == pWin ? 1
                    : g.getTabuleiro()[i][1] == pLose ? -1 : 0;
            count += g.getTabuleiro()[i][2] == pWin ? 1
                    : g.getTabuleiro()[i][2] == pLose ? -1 : 0;
            if (g.getTabuleiro()[i][0] == 'a') {
                jogadaProtetora.setJogada(i, 0);
            } else if (g.getTabuleiro()[i][1] == 'a') {
                jogadaProtetora.setJogada(i, 1);
            } else if (g.getTabuleiro()[i][2] == 'a') {
                jogadaProtetora.setJogada(i, 2);
            }
            if (count == 2) {
                return play("jPro");
            }
        }

        for (int i = 0; i < 3; i++) {
            count = 0;
            count += g.getTabuleiro()[0][i] == pWin ? 1
                    : g.getTabuleiro()[0][i] == pLose ? -1 : 0;
            count += g.getTabuleiro()[1][i] == pWin ? 1
                    : g.getTabuleiro()[1][i] == pLose ? -1 : 0;
            count += g.getTabuleiro()[2][i] == pWin ? 1
                    : g.getTabuleiro()[2][i] == pLose ? -1 : 0;
            if (g.getTabuleiro()[0][i] == 'a') {
                jogadaProtetora.setJogada(0, i);
            } else if (g.getTabuleiro()[1][i] == 'a') {
                jogadaProtetora.setJogada(1, i);
            } else if (g.getTabuleiro()[2][i] == 'a') {
                jogadaProtetora.setJogada(2, i);
            }
            if (count == 2) {
                return play("jPro");
            }
        }

        count = 0;
        count += g.getTabuleiro()[0][0] == pWin ? 1
                : g.getTabuleiro()[0][0] == pLose ? -1 : 0;
        count += g.getTabuleiro()[1][1] == pWin ? 1
                : g.getTabuleiro()[1][1] == pLose ? -1 : 0;
        count += g.getTabuleiro()[2][2] == pWin ? 1
                : g.getTabuleiro()[2][2] == pLose ? -1 : 0;
        if (count == 2) {
            return play("diagonalE");
        }

        count = 0;
        count += g.getTabuleiro()[0][2] == pWin ? 1
                : g.getTabuleiro()[0][2] == pLose ? -1 : 0;
        count += g.getTabuleiro()[1][1] == pWin ? 1
                : g.getTabuleiro()[1][1] == pLose ? -1 : 0;
        count += g.getTabuleiro()[2][0] == pWin ? 1
                : g.getTabuleiro()[2][0] == pLose ? -1 : 0;
        if (count == 2) {
            return play("diagonalD");
        }
        return new Jogada(-1, -1);
    }

    private Jogada jogadaLados() {
        return g.getTabuleiro()[0][1] == g.getTabuleiro()[1][0] &&
                    g.getTabuleiro()[1][0] == g.getPlayer().getTag() ?
                 play("cantoSupE") : 
                (g.getTabuleiro()[0][1] == g.getTabuleiro()[1][2] &&
                    g.getTabuleiro()[1][2]== g.getPlayer().getTag()) ?
                 play("cantoSupD") : 
                (g.getTabuleiro()[1][0] == g.getTabuleiro()[2][1] &&
                    g.getTabuleiro()[1][0]== g.getPlayer().getTag()) ?
                 play("cantoInferiorE") :
                (g.getTabuleiro()[0][1] == g.getTabuleiro()[1][0] &&
                    g.getTabuleiro()[1][0]== g.getPlayer().getTag()) ?
                 play("cantoInferiorD") : new Jogada(-1, -1);
    }
}
