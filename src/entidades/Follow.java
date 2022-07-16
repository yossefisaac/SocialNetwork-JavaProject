package entidades;

public class Follow {
    
    private User segue;
    private User seguidor;
    
    public Follow(User segue, User seguidor) {
	super();
	this.segue = segue;
	this.seguidor = seguidor;
    }

    public Follow(User segue) {
	super();
	this.segue = segue;
    }

    public User getSegue() {
        return segue;
    }

    public void setSegue(User segue) {
        this.segue = segue;
    }

    public User getSeguidor() {
        return seguidor;
    }

    public void setSeguidor(User seguidor) {
        this.seguidor = seguidor;
    }

}