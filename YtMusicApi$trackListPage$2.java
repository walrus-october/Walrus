package com.coldfriesinoctober.walrus.music;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/coldfriesinoctober/walrus/music/YtPage;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$trackListPage$2", f = "YtMusicApi.kt", i = {0, 1, 1, 1, 1, 1, 1, 1}, l = {622, 632}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "title", "subtitle", "artwork", "tracks", "token", "pages"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"})
/* loaded from: classes5.dex */
public final class YtMusicApi$trackListPage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super YtPage>, Object> {
    final /* synthetic */ String $browseId;
    final /* synthetic */ Map<String, String> $cookies;
    final /* synthetic */ int $maxTracks;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$trackListPage$2(String str, int i, Map<String, String> map, Continuation<? super YtMusicApi$trackListPage$2> continuation) {
        super(2, continuation);
        this.$browseId = str;
        this.$maxTracks = i;
        this.$cookies = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        YtMusicApi$trackListPage$2 ytMusicApi$trackListPage$2 = new YtMusicApi$trackListPage$2(this.$browseId, this.$maxTracks, this.$cookies, continuation);
        ytMusicApi$trackListPage$2.L$0 = obj;
        return ytMusicApi$trackListPage$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super YtPage> continuation) {
        return ((YtMusicApi$trackListPage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x00ef, code lost:
    
        r8 = com.coldfriesinoctober.walrus.music.YtMusicApi.INSTANCE.findString(r0, "title");
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01ad A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e5  */
    /* JADX WARN: Type inference failed for: r1v15, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x01ae -> B:11:0x01b3). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            Method dump skipped, instructions count: 652
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi$trackListPage$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
