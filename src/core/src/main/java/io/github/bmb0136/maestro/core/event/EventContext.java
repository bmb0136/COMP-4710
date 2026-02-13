package io.github.bmb0136.maestro.core.event;

import io.github.bmb0136.maestro.core.timeline.Timeline;
import io.github.bmb0136.maestro.core.timeline.Track;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EventContext<T> {
    private final T target;
    private final Timeline timeline;
    private final Track track;

    public EventContext(@NotNull T target, @Nullable Timeline timeline, @Nullable Track track) {
        this.target = target;
        this.timeline = timeline;
        this.track = track;
    }

    public EventContext(@NotNull T target, @Nullable Timeline timeline) {
        this(target, timeline, null);
    }

    public EventContext(@NotNull T target) {
        this(target, null, null);
    }

    @NotNull
    public T getTarget() {
        return target;
    }

    @Nullable
    public Track getTrack() {
        return track;
    }

    @Nullable
    public Timeline getTimeline() {
        return timeline;
    }
}
