package com.ccut.teachingaisystem.domain.question.aiAnalysis.teacher.course;

import com.google.gson.annotations.SerializedName;

public class AiModelScoresText {

    @SerializedName("face_emotion")
    double face_emotion;

    @SerializedName("visual_quality")
    double visual_quality;

    @SerializedName("audio_content")
    double audio_content;

    public AiModelScoresText() {
    }

    public AiModelScoresText(double face_emotion, double visual_quality, double audio_content) {
        this.face_emotion = face_emotion;
        this.visual_quality = visual_quality;
        this.audio_content = audio_content;
    }

    public double getFace_emotion() {
        return face_emotion;
    }

    public void setFace_emotion(double face_emotion) {
        this.face_emotion = face_emotion;
    }

    public double getVisual_quality() {
        return visual_quality;
    }

    public void setVisual_quality(double visual_quality) {
        this.visual_quality = visual_quality;
    }

    public double getAudio_content() {
        return audio_content;
    }

    public void setAudio_content(double audio_content) {
        this.audio_content = audio_content;
    }

    @Override
    public String toString() {
        return new com.google.gson.Gson().toJson(this);
    }
}
