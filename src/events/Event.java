package events;

public abstract class Event {

    private boolean isCancelled = false;

    protected boolean isCancelled() {
        return false;
    }

    private void setCancelled(boolean x){
        this.isCancelled = x;
    }

    public abstract void execute();
}
