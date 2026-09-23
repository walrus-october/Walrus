package com.coldfriesinoctober.walrus.music;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;

/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0010JP\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\tHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006!"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/YtTrack;", "", YoutubeParsingHelper.VIDEO_ID, "", "title", "artist", "album", "artworkUrl", "durationSeconds", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAlbum", "()Ljava/lang/String;", "getArtist", "getArtworkUrl", "getDurationSeconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "getVideoId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/coldfriesinoctober/walrus/music/YtTrack;", "equals", "", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class YtTrack {
    public static final int $stable = 0;
    private final String album;
    private final String artist;
    private final String artworkUrl;
    private final Integer durationSeconds;
    private final String title;
    private final String videoId;

    public YtTrack(String videoId, String title, String artist, String str, String str2, Integer num) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(artist, "artist");
        this.videoId = videoId;
        this.title = title;
        this.artist = artist;
        this.album = str;
        this.artworkUrl = str2;
        this.durationSeconds = num;
    }

    public /* synthetic */ YtTrack(String str, String str2, String str3, String str4, String str5, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : num);
    }

    public static /* synthetic */ YtTrack copy$default(YtTrack ytTrack, String str, String str2, String str3, String str4, String str5, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ytTrack.videoId;
        }
        if ((i & 2) != 0) {
            str2 = ytTrack.title;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = ytTrack.artist;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = ytTrack.album;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = ytTrack.artworkUrl;
        }
        String str9 = str5;
        if ((i & 32) != 0) {
            num = ytTrack.durationSeconds;
        }
        return ytTrack.copy(str, str6, str7, str8, str9, num);
    }

    /* renamed from: component1, reason: from getter */
    public final String getVideoId() {
        return this.videoId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getArtist() {
        return this.artist;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAlbum() {
        return this.album;
    }

    /* renamed from: component5, reason: from getter */
    public final String getArtworkUrl() {
        return this.artworkUrl;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public final YtTrack copy(String videoId, String title, String artist, String album, String artworkUrl, Integer durationSeconds) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(artist, "artist");
        return new YtTrack(videoId, title, artist, album, artworkUrl, durationSeconds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof YtTrack)) {
            return false;
        }
        YtTrack ytTrack = (YtTrack) other;
        return Intrinsics.areEqual(this.videoId, ytTrack.videoId) && Intrinsics.areEqual(this.title, ytTrack.title) && Intrinsics.areEqual(this.artist, ytTrack.artist) && Intrinsics.areEqual(this.album, ytTrack.album) && Intrinsics.areEqual(this.artworkUrl, ytTrack.artworkUrl) && Intrinsics.areEqual(this.durationSeconds, ytTrack.durationSeconds);
    }

    public final String getAlbum() {
        return this.album;
    }

    public final String getArtist() {
        return this.artist;
    }

    public final String getArtworkUrl() {
        return this.artworkUrl;
    }

    public final Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public int hashCode() {
        return (((((((((this.videoId.hashCode() * 31) + this.title.hashCode()) * 31) + this.artist.hashCode()) * 31) + (this.album == null ? 0 : this.album.hashCode())) * 31) + (this.artworkUrl == null ? 0 : this.artworkUrl.hashCode())) * 31) + (this.durationSeconds != null ? this.durationSeconds.hashCode() : 0);
    }

    public String toString() {
        return "YtTrack(videoId=" + this.videoId + ", title=" + this.title + ", artist=" + this.artist + ", album=" + this.album + ", artworkUrl=" + this.artworkUrl + ", durationSeconds=" + this.durationSeconds + ")";
    }
}
