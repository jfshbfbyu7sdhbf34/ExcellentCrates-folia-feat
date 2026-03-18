package su.nightexpress.excellentcrates.util;

public enum InteractType {
<<<<<<< HEAD
    CRATE_OPEN,
    CRATE_MASS_OPEN,
    CRATE_PREVIEW
=======

    CRATE_OPEN,
    CRATE_PREVIEW;

    public InteractType reversed() {
        return this == CRATE_OPEN ? CRATE_PREVIEW : CRATE_OPEN;
    }
>>>>>>> upstream/master
}
