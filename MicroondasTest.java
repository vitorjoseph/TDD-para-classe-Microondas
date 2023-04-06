import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

public class MicroondasTest {

    Microondas teste;

    @BeforeEach
    void setUp(){
        teste = new Microondas();
    }
    
    //Status possíveis do microondas
    @Test
    void Ligar(){ 
        
        assertEquals(1, teste.ligar());
    }

    @Test
    void Desligar(){ 
        
        assertEquals(0, teste.desligar());
    }

    @Test
    void Pause(){ 
         
        assertEquals(true, teste.pause());
    }

    @Test
    void Play(){ 
         
        assertEquals(false, teste.play());
    }

     //Porta
   

    @Test
    void AbrirPorta(){ 
        
        assertEquals(true, teste.abrirPorta());
    }

    @Test
    void FecharPorta(){ 
         
        assertEquals(false, teste.fecharPorta());
    }

    //Ligar o microondas com a porta aberta

    @Test
    void LigadoStatusPorta1(){ // 0 == desligado
        teste.abrirPorta();
           
        assertEquals(0, teste.ligar());
    }
    @Test
    void LigadoStatusPorta2(){  // 1 == ligado
        teste.abrirPorta();
        teste.fecharPorta();
           
        assertEquals(1, teste.ligar());
    }

    //Abrir porta com o microondas ligado

    @Test
    void PortaStatusLigado1(){ // false == porta fechada
        teste.ligar();
           
        assertEquals(false, teste.abrirPorta());
    }
    @Test
    void PortaStatusLigado2(){  // true == porta aberta
        teste.ligar();
        teste.desligar();
           
        assertEquals(true, teste.abrirPorta());
    }

    //Ajustar o timer, aceitando segundos negativos e acima de 60

    @Test
    void mostrarTimer(){

        assertEquals("00:00", teste.mostrarTimer()); //00:00, status inicial do timer
    }

    @Test
    void ajustarTimer1(){

        teste.ajustarTimer(30, 120);
        assertEquals("32:00", teste.mostrarTimer());             
    }

    @Test
    void ajustarTimer2(){

        teste.ajustarTimer(59, 30);
        assertEquals("59:30", teste.mostrarTimer());      
    }

    @Test
    void ajustarTimer3(){

        teste.ajustarTimer(10, 2421);
        assertEquals("50:21", teste.mostrarTimer());      
    }

    @Test
    void ajustarTimer4(){

        teste.ajustarTimer(10, -60);
        assertEquals("09:00", teste.mostrarTimer());         
    }

    @Test
    void ajustarTimer5(){
        
        teste.ajustarTimer(59, -1220);
        assertEquals("38:40", teste.mostrarTimer());         
    }

    @Test
    void ajustarTimer6(){ //Caso seja negativo, retorna 00:00
        
        teste.ajustarTimer(0, -1);
        assertEquals("00:00", teste.mostrarTimer());         
    }

    //Testes do timer, o tempo é inicialmente setado em ajustarTimer e posteriormente o tempo que queira decrescer é setado no método timer

    @Test
    void timer1(){
        
        teste.ajustarTimer(3,00);
        teste.timer(2,50);
        assertEquals("00:10", teste.mostrarTimer());         
    }

    @Test
    void timer2(){
        
        teste.ajustarTimer(10,00);
        teste.timer(1,59);
        assertEquals("08:01", teste.mostrarTimer());         
    }

    @Test
    void timer3(){
        
        teste.ajustarTimer(1,61);
        teste.timer(2,01);
        assertEquals("00:00", teste.mostrarTimer());         
    }

    //Pausar, despausar, timer com porta aberta
    @Test
    void testePausar(){ // Retorna o tempo setado em ajustarTimer, não acionando o  timer
        
        teste.ajustarTimer(10,20);
        teste.pause();
        teste.timer(3,00);
        assertEquals("10:20", teste.mostrarTimer());         
    }
    @Test
    void testeDespausar(){
        
        teste.ajustarTimer(05,-20);
        teste.pause();
        teste.play();
        teste.timer(1,00);
        assertEquals("03:40", teste.mostrarTimer());
    }

}
    

    
    

