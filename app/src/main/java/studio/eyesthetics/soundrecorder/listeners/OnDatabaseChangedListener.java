package studio.eyesthetics.soundrecorder.listeners;

public interface OnDatabaseChangedListener {
    void onNewDatabaseEntryAdded();
    void onDatabaseEntryRenamed();
}
