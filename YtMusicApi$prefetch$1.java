package com.coldfriesinoctober.walrus.music;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$prefetch$1", f = "YtMusicApi.kt", i = {}, l = {697}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class YtMusicApi$prefetch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $videoId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$prefetch$1(String str, Continuation<? super YtMusicApi$prefetch$1> continuation) {
        super(2, continuation);
        this.$videoId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new YtMusicApi$prefetch$1(this.$videoId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((YtMusicApi$prefetch$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        YtMusicApi$prefetch$1 ytMusicApi$prefetch$1;
        ConcurrentHashMap.KeySetView keySetView;
        ConcurrentHashMap.KeySetView keySetView2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                try {
                    this.label = 1;
                } catch (Exception e) {
                    ytMusicApi$prefetch$1 = this;
                } catch (Throwable th2) {
                    th = th2;
                    ytMusicApi$prefetch$1 = this;
                    keySetView = YtMusicApi.prefetching;
                    keySetView.remove(ytMusicApi$prefetch$1.$videoId);
                    throw th;
                }
                if (YtMusicApi.INSTANCE.resolveStream(this.$videoId, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ytMusicApi$prefetch$1 = this;
                keySetView2 = YtMusicApi.prefetching;
                keySetView2.remove(ytMusicApi$prefetch$1.$videoId);
                return Unit.INSTANCE;
            case 1:
                ytMusicApi$prefetch$1 = this;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e2) {
                } catch (Throwable th3) {
                    th = th3;
                    keySetView = YtMusicApi.prefetching;
                    keySetView.remove(ytMusicApi$prefetch$1.$videoId);
                    throw th;
                }
                keySetView2 = YtMusicApi.prefetching;
                keySetView2.remove(ytMusicApi$prefetch$1.$videoId);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
