import { AudioPlayer } from "./audio-player";
import { MediaFormat } from "./media-format";


export class WAVPlayer implements AudioPlayer {
    volume: number;
    playBackRate: number;

    constructor(volume: number, playBackRate: number) {
        this.volume = volume;
        this.playBackRate = playBackRate;
    }

    public play():void {
        // Simulate playing audio in WAV format
        // Each media format will have its own implementation
        console.log("Playing WAV audio");
    }

    public pause():void {
        // Simulate pausing audio in WAV format
        // Each media format will have its own implementation
        console.log("Pausing WAV audio");
    }

    public stop():void {
        // Simulate stopping audio in WAV format
        // Each media format will have its own implementation
        console.log("Stopping WAV audio");
    }

    public getVolume(): number {
        return this.volume;
    }

    public setVolume(volume: number): void {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
           console.log("Volume set to " + this.volume);
        } else {
           console.log("Invalid volume level");
        }
    }

    public getPlayBackRate(): number {
        return this.playBackRate;
    }

    public supportsType(): MediaFormat {
        return MediaFormat.WAV;
    }
}