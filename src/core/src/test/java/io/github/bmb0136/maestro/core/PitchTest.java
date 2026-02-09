package io.github.bmb0136.maestro.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PitchTest {
    @Test
    public void toMidi_middleCCorrect() {
        assertEquals(60, new Pitch(PitchName.C, 4).toMidi());
    }

    @Test
    public void fromMidi_middleCCorrect() {
        assertEquals(new Pitch(PitchName.C, 4), Pitch.fromMidi(60, false));
        assertEquals(new Pitch(PitchName.C, 4), Pitch.fromMidi(60, true));
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, -2, -1, 128, 129, 130})
    public void fromMidi_outsideMidiRange_throws(int midi) {
        assertThrows(IllegalArgumentException.class, () -> Pitch.fromMidi(midi, false));
        assertThrows(IllegalArgumentException.class, () -> Pitch.fromMidi(midi, true));
    }

    @ParameterizedTest
    @MethodSource("io.github.bmb0136.maestro.core.TestUtil#allMidiNotes")
    public void fromMidi_insideMidiRange_succeeds(int midi) {
        assertDoesNotThrow(() -> Pitch.fromMidi(midi, false));
        assertDoesNotThrow(() -> Pitch.fromMidi(midi, true));
    }

    @ParameterizedTest
    @MethodSource("io.github.bmb0136.maestro.core.TestUtil#allMidiNotes")
    public void midiConversion_alwaysEqual(int midi) {
        assertEquals(midi, Pitch.fromMidi(midi, false).toMidi());
        assertEquals(midi, Pitch.fromMidi(midi, true).toMidi());
    }
}