package io.github.bmb0136.maestro;

import io.github.bmb0136.maestro.core.event.AddTrackToTimelineEvent;
import io.github.bmb0136.maestro.core.timeline.Timeline;
import io.github.bmb0136.maestro.core.timeline.TimelineManager;
import io.github.bmb0136.maestro.core.timeline.Track;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.SubScene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class AppController {

    @FXML
    private ScrollPane trackListScrollPane;
    @FXML
    private VBox trackList;
    private final TimelineManager manager = new TimelineManager(1024, new Timeline());

    @FXML
    public void onAddTrackButtonClicked() throws IOException {
        Track track = new Track();
        if (!manager.append(new AddTrackToTimelineEvent(track)).isOk()) {
            return;
        }

        URL resource = Objects.requireNonNull(getClass().getResource("/Track.fxml"));
        FXMLLoader loader = new FXMLLoader(resource);
        loader.setController(new TrackController(manager, track.getId()));
        SubScene subScene = new SubScene(loader.load(), 240, 120);
        trackList.getChildren().add(subScene);
    }
}
