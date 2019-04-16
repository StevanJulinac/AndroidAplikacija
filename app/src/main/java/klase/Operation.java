package klase;

public class Operation{

    private boolean move;
    private boolean copy;
    private boolean delete;

    public Operation(boolean move, boolean copy, boolean delete) {
        this.move = move;
        this.copy = copy;
        this.delete = delete;
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    public boolean isCopy() {
        return copy;
    }

    public void setCopy(boolean copy) {
        this.copy = copy;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }
}
