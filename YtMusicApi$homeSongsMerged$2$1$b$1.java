package com.coldfriesinoctober.walrus.music;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/coldfriesinoctober/walrus/music/YtTrack;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$homeSongsMerged$2$1$b$1", f = "YtMusicApi.kt", i = {}, l = {546}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class YtMusicApi$homeSongsMerged$2$1$b$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends YtTrack>>, Object> {
    final /* synthetic */ int $limit;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$homeSongsMerged$2$1$b$1(int i, Continuation<? super YtMusicApi$homeSongsMerged$2$1$b$1> continuation) {
        super(2, continuation);
        this.$limit = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        YtMusicApi$homeSongsMerged$2$1$b$1 ytMusicApi$homeSongsMerged$2$1$b$1 = new YtMusicApi$homeSongsMerged$2$1$b$1(this.$limit, continuation);
        ytMusicApi$homeSongsMerged$2$1$b$1.L$0 = obj;
        return ytMusicApi$homeSongsMerged$2$1$b$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends YtTrack>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<YtTrack>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<YtTrack>> continuation) {
        return ((YtMusicApi$homeSongsMerged$2$1$b$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            switch(r1) {
                case 0: goto L1f;
                case 1: goto L11;
                default: goto L9;
            }
        L9:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L11:
            r0 = r9
            r1 = 0
            int r2 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L1d
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r10
            goto L42
        L1d:
            r1 = move-exception
            goto L62
        L1f:
            kotlin.ResultKt.throwOnFailure(r10)
            r1 = r9
            java.lang.Object r2 = r1.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            int r3 = r1.$limit
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L5e
            r2 = 0
            com.coldfriesinoctober.walrus.music.YtMusicApi r4 = com.coldfriesinoctober.walrus.music.YtMusicApi.INSTANCE     // Catch: java.lang.Throwable -> L5e
            java.lang.String r5 = "FEmusic_home"
            java.util.Map r6 = com.coldfriesinoctober.walrus.music.YtMusicApi.access$getSessionCookies2$p()     // Catch: java.lang.Throwable -> L5e
            r1.I$0 = r3     // Catch: java.lang.Throwable -> L5e
            r7 = 1
            r1.label = r7     // Catch: java.lang.Throwable -> L5e
            java.lang.Object r4 = com.coldfriesinoctober.walrus.music.YtMusicApi.access$browse(r4, r5, r6, r1)     // Catch: java.lang.Throwable -> L5e
            if (r4 != r0) goto L40
            return r0
        L40:
            r0 = r10
            r10 = r4
        L42:
            kotlinx.serialization.json.JsonObject r10 = (kotlinx.serialization.json.JsonObject) r10     // Catch: java.lang.Throwable -> L58
            com.coldfriesinoctober.walrus.music.YtMusicApi r4 = com.coldfriesinoctober.walrus.music.YtMusicApi.INSTANCE     // Catch: java.lang.Throwable -> L58
            r5 = r10
            kotlinx.serialization.json.JsonElement r5 = (kotlinx.serialization.json.JsonElement) r5     // Catch: java.lang.Throwable -> L58
            java.util.List r4 = com.coldfriesinoctober.walrus.music.YtMusicApi.access$parseHomeFeedSongs(r4, r5)     // Catch: java.lang.Throwable -> L58
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch: java.lang.Throwable -> L58
            java.util.List r3 = kotlin.collections.CollectionsKt.take(r4, r3)     // Catch: java.lang.Throwable -> L58
            java.lang.Object r10 = kotlin.Result.m6535constructorimpl(r3)     // Catch: java.lang.Throwable -> L58
            goto L70
        L58:
            r10 = move-exception
            r8 = r1
            r1 = r10
            r10 = r0
            r0 = r8
            goto L62
        L5e:
            r0 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
        L62:
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
            java.lang.Object r1 = kotlin.Result.m6535constructorimpl(r1)
            r8 = r0
            r0 = r10
            r10 = r1
            r1 = r8
        L70:
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            boolean r3 = kotlin.Result.m6541isFailureimpl(r10)
            if (r3 == 0) goto L7b
            r10 = r2
        L7b:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coldfriesinoctober.walrus.music.YtMusicApi$homeSongsMerged$2$1$b$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
