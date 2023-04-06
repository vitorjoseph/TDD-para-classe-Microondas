public class Microondas {

    private boolean statusPorta = false, pausar = false; // inicia-se fechada = false
    static int Status = 0; // 0 significa desligado, status padrão do microondas
    private int min, sec;

    public int ligar() {
        if (statusPorta == false) {
            Status = 1;
        }
        return Status;

    }

    public int desligar() {
        Status = 0;
        return Status;
    }

    public boolean pause() {
        pausar = true;
        return pausar;
    }

    public boolean play() {
        pausar = false;
        return pausar;
    }

    // ------------------------------------------------------------------

    public boolean abrirPorta() {
        if (Status == 0) {
            statusPorta = true;
        }
        return statusPorta;

    }

    public boolean fecharPorta() {
        statusPorta = false;

        return statusPorta;

    }

    // ------------------------------------------------------------------

    public String mostrarTimer() {

        return String.format("%02d:%02d", this.min, this.sec);
    }

    public void ajustarTimer(int minutos, int segundos) {

        if (minutos <= 59 && minutos >= 0 && segundos >= 0) {
            while (segundos > 59) {
                segundos = segundos - 60;
                minutos++;
                if (minutos > 59 && segundos > 59) {
                    this.sec = 0;
                    this.min = 0;
                }
            }
        }
        if (minutos >= 0) {
            while (segundos < 0) {
                segundos = segundos + 60;
                minutos--;
            }
        }
        this.sec = segundos;
        this.min = minutos;

        if (minutos < 0) {
            this.sec = 0;
            this.min = 0;

        }
    }

    // ------------------------------------------------------------------

    public void timer(int minutos, int segundos) {

        if (!pausar) {
            if(segundos != this.sec){
                min--;
                sec+=60;
            }
            while (!(minutos == 0 && segundos == 0)) {
                if (segundos > 0) {
                    segundos--;
                    this.sec--;
                }
                if (minutos > 0 && segundos == 0) {
                    minutos--;
                    this.min--;
                    this.sec += 60;
                    segundos += 60;
                }
            }
            ajustarTimer(this.min, this.sec);
        }
    }

    public static void main(String[] args) {
    }

}
