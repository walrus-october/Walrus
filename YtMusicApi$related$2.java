package com.coldfriesinoctober.walrus.music;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/coldfriesinoctober/walrus/music/YtTrack;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$related$2", f = "YtMusicApi.kt", i = {}, l = {594, 595}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class YtMusicApi$related$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends YtTrack>>, Object> {
    final /* synthetic */ int $limit;
    final /* synthetic */ String $videoId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$related$2(String str, int i, Continuation<? super YtMusicApi$related$2> continuation) {
        super(2, continuation);
        this.$videoId = str;
        this.$limit = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new YtMusicApi$related$2(this.$videoId, this.$limit, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends YtTrack>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<YtTrack>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<YtTrack>> continuation) {
        return ((YtMusicApi$related$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0009. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e5  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi$related$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
