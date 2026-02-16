package io.github.bmb0136.maestro;

import io.github.bmb0136.maestro.core.timeline.TimelineManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.UUID;

public class TrackController {
    private final TimelineManager manager;
    private final UUID trackId;
    @FXML
    private Label nameLabel;

    public TrackController(TimelineManager manager, UUID trackId) {
        this.manager = manager;
        this.trackId = trackId;
    }

    public void initialize() {
        manager.get().getTrack(trackId).ifPresent(t -> nameLabel.setText(t.getName()));
    }
}
