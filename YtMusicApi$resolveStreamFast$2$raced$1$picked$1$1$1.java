package com.coldfriesinoctober.walrus.music;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Deferred;

/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00030\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/coldfriesinoctober/walrus/music/YtStream;", "Lkotlinx/coroutines/Deferred;", CmcdData.Factory.STREAMING_FORMAT_SS}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$resolveStreamFast$2$raced$1$picked$1$1$1", f = "YtMusicApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class YtMusicApi$resolveStreamFast$2$raced$1$picked$1$1$1 extends SuspendLambda implements Function2<YtStream, Continuation<? super Pair<? extends YtStream, ? extends Deferred<? extends YtStream>>>, Object> {
    final /* synthetic */ Deferred<YtStream> $d;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$resolveStreamFast$2$raced$1$picked$1$1$1(Deferred<YtStream> deferred, Continuation<? super YtMusicApi$resolveStreamFast$2$raced$1$picked$1$1$1> continuation) {
        super(2, continuation);
        this.$d = deferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        YtMusicApi$resolveStreamFast$2$raced$1$picked$1$1$1 ytMusicApi$resolveStreamFast$2$raced$1$picked$1$1$1 = new YtMusicApi$resolveStreamFast$2$raced$1$picked$1$1$1(this.$d, continuation);
        ytMusicApi$resolveStreamFast$2$raced$1$picked$1$1$1.L$0 = obj;
        return ytMusicApi$resolveStreamFast$2$raced$1$picked$1$1$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(YtStream ytStream, Continuation<? super Pair<YtStream, ? extends Deferred<YtStream>>> continuation) {
        return ((YtMusicApi$resolveStreamFast$2$raced$1$picked$1$1$1) create(ytStream, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(YtStream ytStream, Continuation<? super Pair<? extends YtStream, ? extends Deferred<? extends YtStream>>> continuation) {
        return invoke2(ytStream, (Continuation<? super Pair<YtStream, ? extends Deferred<YtStream>>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                return TuplesKt.to((YtStream) this.L$0, this.$d);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
