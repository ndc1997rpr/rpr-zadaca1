package ba.unsa.etf.rpr;

public class Queen extends Chesspiece {

    public Queen(Color boja, String pozicija) throws IllegalChessMoveException{
        super(boja,pozicija);
        if(!provjeriPoziciju(pozicija)) throw new IllegalChessMoveException("Ilegalna pozicija");
    }

    @Override
    public String getPosition(){
        return pozicija;
    }

    @Override
    public Color getColor() {
        return boja;
    }

    @Override
    public void move(String position) throws IllegalChessMoveException{
        char slovo = position.charAt(0);
        int broj = position.charAt(1) - '0';

        if(!provjeriPoziciju(position)){
            throw new IllegalChessMoveException("Ilegalan potez");
        }
        char slovo_p = pozicija.charAt(0);
        int broj_p = pozicija.charAt(1) - '0';

        if(slovo == slovo_p && broj == broj_p){
            throw new IllegalChessMoveException("Ilegalan potez");
        }
        if(slovo == slovo_p || broj == broj_p || Math.abs(slovo - slovo_p ) == Math.abs(broj - broj_p)){
            pozicija = position;
        }
        else {
            throw new IllegalChessMoveException("Ilegalan potez");
        }
    }
}
