import { AudioPlayer } from "./audio-player";
import { AudioPlayerFactory } from "./audio-player-factory";
import { MediaFormat } from "./media-format";

// Create audio players using the factory
const mp3Player = AudioPlayerFactory.getAudioPlayer(MediaFormat.MP3, 50, 1.0);
const wavPlayer = AudioPlayerFactory.getAudioPlayer(MediaFormat.WAV, 75, 1.5);
const flacPlayer = AudioPlayerFactory.getAudioPlayer(MediaFormat.FLAC, 80, 0.8);

// Output audio players
console.log("MP3 Player:", mp3Player);
console.log("WAV Player:", wavPlayer);
console.log("FLAC Player:", flacPlayer);
