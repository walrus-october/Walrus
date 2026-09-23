package com.coldfriesinoctober.walrus.music;

import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.coldfriesinoctober.walrus.Prefs;
import com.coldfriesinoctober.walrus.music.PlayHistory;
import com.coldfriesinoctober.walrus.ui.Song;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;
import org.schabi.newpipe.extractor.services.peertube.PeertubeParsingHelper;
import org.schabi.newpipe.extractor.services.youtube.YoutubeParsingHelper;
import org.schabi.newpipe.extractor.stream.Stream;

/* compiled from: PlayHistory.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/PlayHistory;", "", "()V", "MAX_ENTRIES", "", "SEED_WINDOW_MS", "", "clean", "", CmcdData.Factory.STREAMING_FORMAT_SS, "clear", "", "load", "", "Lcom/coldfriesinoctober/walrus/music/PlayHistory$Entry;", "mostPlayed", "", "limit", "record", "song", "Lcom/coldfriesinoctober/walrus/ui/Song;", "seedVideoIds", "Entry", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PlayHistory {
    public static final int $stable = 0;
    public static final PlayHistory INSTANCE = new PlayHistory();
    private static final int MAX_ENTRIES = 500;
    private static final long SEED_WINDOW_MS = 2592000000L;

    /* compiled from: PlayHistory.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006!"}, d2 = {"Lcom/coldfriesinoctober/walrus/music/PlayHistory$Entry;", "", TtmlNode.ATTR_ID, "", YoutubeParsingHelper.VIDEO_ID, "title", "artist", PeertubeParsingHelper.COUNT_KEY, "", "lastMs", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJ)V", "getArtist", "()Ljava/lang/String;", "getCount", "()I", "getId", "getLastMs", "()J", "getTitle", "getVideoId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Entry {
        public static final int $stable = 0;
        private final String artist;
        private final int count;
        private final String id;
        private final long lastMs;
        private final String title;
        private final String videoId;

        public Entry(String id, String str, String title, String artist, int i, long j) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(artist, "artist");
            this.id = id;
            this.videoId = str;
            this.title = title;
            this.artist = artist;
            this.count = i;
            this.lastMs = j;
        }

        public static /* synthetic */ Entry copy$default(Entry entry, String str, String str2, String str3, String str4, int i, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = entry.id;
            }
            if ((i2 & 2) != 0) {
                str2 = entry.videoId;
            }
            String str5 = str2;
            if ((i2 & 4) != 0) {
                str3 = entry.title;
            }
            String str6 = str3;
            if ((i2 & 8) != 0) {
                str4 = entry.artist;
            }
            String str7 = str4;
            if ((i2 & 16) != 0) {
                i = entry.count;
            }
            int i3 = i;
            if ((i2 & 32) != 0) {
                j = entry.lastMs;
            }
            return entry.copy(str, str5, str6, str7, i3, j);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getVideoId() {
            return this.videoId;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component4, reason: from getter */
        public final String getArtist() {
            return this.artist;
        }

        /* renamed from: component5, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        /* renamed from: component6, reason: from getter */
        public final long getLastMs() {
            return this.lastMs;
        }

        public final Entry copy(String id, String videoId, String title, String artist, int count, long lastMs) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(artist, "artist");
            return new Entry(id, videoId, title, artist, count, lastMs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) other;
            return Intrinsics.areEqual(this.id, entry.id) && Intrinsics.areEqual(this.videoId, entry.videoId) && Intrinsics.areEqual(this.title, entry.title) && Intrinsics.areEqual(this.artist, entry.artist) && this.count == entry.count && this.lastMs == entry.lastMs;
        }

        public final String getArtist() {
            return this.artist;
        }

        public final int getCount() {
            return this.count;
        }

        public final String getId() {
            return this.id;
        }

        public final long getLastMs() {
            return this.lastMs;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getVideoId() {
            return this.videoId;
        }

        public int hashCode() {
            return (((((((((this.id.hashCode() * 31) + (this.videoId == null ? 0 : this.videoId.hashCode())) * 31) + this.title.hashCode()) * 31) + this.artist.hashCode()) * 31) + Integer.hashCode(this.count)) * 31) + Long.hashCode(this.lastMs);
        }

        public String toString() {
            return "Entry(id=" + this.id + ", videoId=" + this.videoId + ", title=" + this.title + ", artist=" + this.artist + ", count=" + this.count + ", lastMs=" + this.lastMs + ")";
        }
    }

    private PlayHistory() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String clean(String s) {
        return StringsKt.trim((CharSequence) StringsKt.replace$default(StringsKt.replace$default(s, "|", "/", false, 4, (Object) null), IOUtils.LINE_SEPARATOR_UNIX, Stream.ID_UNKNOWN, false, 4, (Object) null)).toString();
    }

    public static /* synthetic */ List mostPlayed$default(PlayHistory playHistory, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 20;
        }
        return playHistory.mostPlayed(i);
    }

    public final void clear() {
        Prefs.INSTANCE.setBlocking(Prefs.INSTANCE.getMUSIC_HISTORY(), "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, Entry> load() {
        String str = (String) Prefs.INSTANCE.get(Prefs.INSTANCE.getMUSIC_HISTORY(), "");
        if (StringsKt.isBlank(str)) {
            return MapsKt.emptyMap();
        }
        List<String> lines = StringsKt.lines(str);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = lines.iterator();
        while (it.hasNext()) {
            String str2 = str;
            List<String> list = lines;
            List split$default = StringsKt.split$default((CharSequence) it.next(), new String[]{"|"}, false, 0, 6, (Object) null);
            if (split$default.size() >= 6) {
                String str3 = (String) split$default.get(0);
                Object obj = split$default.get(1);
                String str4 = (String) (StringsKt.isBlank((String) obj) ^ true ? obj : null);
                String str5 = (String) split$default.get(2);
                String str6 = (String) split$default.get(3);
                Integer intOrNull = StringsKt.toIntOrNull((String) split$default.get(4));
                int intValue = intOrNull != null ? intOrNull.intValue() : 1;
                Long longOrNull = StringsKt.toLongOrNull((String) split$default.get(5));
                r16 = new Entry(str3, str4, str5, str6, intValue, longOrNull != null ? longOrNull.longValue() : 0L);
            }
            if (r16 != null) {
                arrayList.add(r16);
            }
            str = str2;
            lines = list;
        }
        ArrayList arrayList2 = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Object obj2 : arrayList2) {
            linkedHashMap.put(((Entry) obj2).getId(), obj2);
        }
        return linkedHashMap;
    }

    public final List<Entry> mostPlayed(int limit) {
        long currentTimeMillis = System.currentTimeMillis();
        Collection<Entry> values = load().values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            if (currentTimeMillis - ((Entry) obj).getLastMs() < SEED_WINDOW_MS) {
                arrayList.add(obj);
            }
        }
        final Comparator comparator = new Comparator() { // from class: com.coldfriesinoctober.walrus.music.PlayHistory$mostPlayed$$inlined$compareByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((PlayHistory.Entry) t2).getCount()), Integer.valueOf(((PlayHistory.Entry) t).getCount()));
            }
        };
        return CollectionsKt.take(CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.coldfriesinoctober.walrus.music.PlayHistory$mostPlayed$$inlined$thenByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compare = comparator.compare(t, t2);
                return compare != 0 ? compare : ComparisonsKt.compareValues(Long.valueOf(((PlayHistory.Entry) t2).getLastMs()), Long.valueOf(((PlayHistory.Entry) t).getLastMs()));
            }
        }), limit);
    }

    public final synchronized void record(Song song) {
        Intrinsics.checkNotNullParameter(song, "song");
        long currentTimeMillis = System.currentTimeMillis();
        Map mutableMap = MapsKt.toMutableMap(load());
        Entry entry = (Entry) mutableMap.get(song.getId());
        mutableMap.put(song.getId(), new Entry(song.getId(), song.getVideoId(), song.getTitle(), song.getArtist(), (entry != null ? entry.getCount() : 0) + 1, currentTimeMillis));
        Prefs.INSTANCE.setBlocking(Prefs.INSTANCE.getMUSIC_HISTORY(), CollectionsKt.joinToString$default(CollectionsKt.take(CollectionsKt.sortedWith(mutableMap.values(), new Comparator() { // from class: com.coldfriesinoctober.walrus.music.PlayHistory$record$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((PlayHistory.Entry) t2).getLastMs()), Long.valueOf(((PlayHistory.Entry) t).getLastMs()));
            }
        }), 500), IOUtils.LINE_SEPARATOR_UNIX, null, null, 0, null, new Function1<Entry, CharSequence>() { // from class: com.coldfriesinoctober.walrus.music.PlayHistory$record$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(PlayHistory.Entry e) {
                String clean;
                String clean2;
                String clean3;
                String clean4;
                Intrinsics.checkNotNullParameter(e, "e");
                String[] strArr = new String[6];
                clean = PlayHistory.INSTANCE.clean(e.getId());
                strArr[0] = clean;
                PlayHistory playHistory = PlayHistory.INSTANCE;
                String videoId = e.getVideoId();
                if (videoId == null) {
                    videoId = "";
                }
                clean2 = playHistory.clean(videoId);
                strArr[1] = clean2;
                clean3 = PlayHistory.INSTANCE.clean(e.getTitle());
                strArr[2] = clean3;
                clean4 = PlayHistory.INSTANCE.clean(e.getArtist());
                strArr[3] = clean4;
                strArr[4] = String.valueOf(e.getCount());
                strArr[5] = String.valueOf(e.getLastMs());
                return CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) strArr), "|", null, null, 0, null, null, 62, null);
            }
        }, 30, null));
    }

    public final List<String> seedVideoIds(int limit) {
        long currentTimeMillis = System.currentTimeMillis();
        Collection<Entry> values = load().values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = values.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Entry) next).getVideoId() != null) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (currentTimeMillis - ((Entry) obj).getLastMs() < SEED_WINDOW_MS) {
                arrayList3.add(obj);
            }
        }
        final Comparator comparator = new Comparator() { // from class: com.coldfriesinoctober.walrus.music.PlayHistory$seedVideoIds$$inlined$compareByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((PlayHistory.Entry) t2).getCount()), Integer.valueOf(((PlayHistory.Entry) t).getCount()));
            }
        };
        List sortedWith = CollectionsKt.sortedWith(arrayList3, new Comparator() { // from class: com.coldfriesinoctober.walrus.music.PlayHistory$seedVideoIds$$inlined$thenByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compare = comparator.compare(t, t2);
                return compare != 0 ? compare : ComparisonsKt.compareValues(Long.valueOf(((PlayHistory.Entry) t2).getLastMs()), Long.valueOf(((PlayHistory.Entry) t).getLastMs()));
            }
        });
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = sortedWith.iterator();
        while (it2.hasNext()) {
            String videoId = ((Entry) it2.next()).getVideoId();
            if (videoId != null) {
                arrayList4.add(videoId);
            }
        }
        ArrayList arrayList5 = arrayList4;
        List take = CollectionsKt.take(CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.coldfriesinoctober.walrus.music.PlayHistory$seedVideoIds$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((PlayHistory.Entry) t2).getLastMs()), Long.valueOf(((PlayHistory.Entry) t).getLastMs()));
            }
        }), 2);
        ArrayList arrayList6 = new ArrayList();
        Iterator it3 = take.iterator();
        while (it3.hasNext()) {
            String videoId2 = ((Entry) it3.next()).getVideoId();
            if (videoId2 != null) {
                arrayList6.add(videoId2);
            }
        }
        return CollectionsKt.take(CollectionsKt.distinct(CollectionsKt.plus((Collection) arrayList6, (Iterable) arrayList5)), limit);
    }
}
