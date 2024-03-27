import { MediaFormat } from "./media-format";

export interface AudioPlayer{
    volume: number;
    playBackRate: number;

    play():void;
    pause():void;
    stop():void;

    setVolume(volume: number):void;
    getVolume():number
    getPlayBackRate():number;

    supportsType():MediaFormat;
}