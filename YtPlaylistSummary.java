package com.coldfriesinoctober.walrus.music;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/YtPlaylistSummary;", "", TtmlNode.ATTR_ID, "", "title", "author", "trackCountText", "artworkUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getArtworkUrl", "()Ljava/lang/String;", "getAuthor", "getId", "getTitle", "getTrackCountText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class YtPlaylistSummary {
    public static final int $stable = 0;
    private final String artworkUrl;
    private final String author;
    private final String id;
    private final String title;
    private final String trackCountText;

    public YtPlaylistSummary(String id, String title, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        this.id = id;
        this.title = title;
        this.author = str;
        this.trackCountText = str2;
        this.artworkUrl = str3;
    }

    public /* synthetic */ YtPlaylistSummary(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    public static /* synthetic */ YtPlaylistSummary copy$default(YtPlaylistSummary ytPlaylistSummary, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ytPlaylistSummary.id;
        }
        if ((i & 2) != 0) {
            str2 = ytPlaylistSummary.title;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = ytPlaylistSummary.author;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = ytPlaylistSummary.trackCountText;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = ytPlaylistSummary.artworkUrl;
        }
        return ytPlaylistSummary.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAuthor() {
        return this.author;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTrackCountText() {
        return this.trackCountText;
    }

    /* renamed from: component5, reason: from getter */
    public final String getArtworkUrl() {
        return this.artworkUrl;
    }

    public final YtPlaylistSummary copy(String id, String title, String author, String trackCountText, String artworkUrl) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        return new YtPlaylistSummary(id, title, author, trackCountText, artworkUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof YtPlaylistSummary)) {
            return false;
        }
        YtPlaylistSummary ytPlaylistSummary = (YtPlaylistSummary) other;
        return Intrinsics.areEqual(this.id, ytPlaylistSummary.id) && Intrinsics.areEqual(this.title, ytPlaylistSummary.title) && Intrinsics.areEqual(this.author, ytPlaylistSummary.author) && Intrinsics.areEqual(this.trackCountText, ytPlaylistSummary.trackCountText) && Intrinsics.areEqual(this.artworkUrl, ytPlaylistSummary.artworkUrl);
    }

    public final String getArtworkUrl() {
        return this.artworkUrl;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTrackCountText() {
        return this.trackCountText;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + (this.author == null ? 0 : this.author.hashCode())) * 31) + (this.trackCountText == null ? 0 : this.trackCountText.hashCode())) * 31) + (this.artworkUrl != null ? this.artworkUrl.hashCode() : 0);
    }

    public String toString() {
        return "YtPlaylistSummary(id=" + this.id + ", title=" + this.title + ", author=" + this.author + ", trackCountText=" + this.trackCountText + ", artworkUrl=" + this.artworkUrl + ")";
    }
}
