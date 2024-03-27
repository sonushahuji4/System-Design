import { AudioPlayer } from "./audio-player";
import { FLACPlayer } from "./flac-player";
import { MediaFormat } from "./media-format";
import { MP3Player } from "./mp3-player";
import { WAVPlayer } from "./wav-player";

export class AudioPlayerFactory {
    static getAudioPlayer(MP3: MediaFormat, arg1: number, arg2: number) {
        throw new Error("Method not implemented.");
    }
    public static getNotification(type: MediaFormat , volume: number, playBackRate: number): AudioPlayer  | null {
        switch(type) {
            case MediaFormat.FLAC: 
                return new FLACPlayer(volume, playBackRate);
            case MediaFormat.MP3: 
                return new MP3Player(volume, playBackRate);
            case MediaFormat.WAV: 
                return new WAVPlayer(volume, playBackRate);
            default:
                return null; // Handle the case where type doesn't match any of the known types
        }
    }
}
