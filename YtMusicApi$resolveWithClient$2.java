package com.coldfriesinoctober.walrus.music;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: YtMusicApi.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/coldfriesinoctober/walrus/music/YtStream;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.coldfriesinoctober.walrus.music.YtMusicApi$resolveWithClient$2", f = "YtMusicApi.kt", i = {}, l = {907}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class YtMusicApi$resolveWithClient$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super YtStream>, Object> {
    final /* synthetic */ List<YtStream> $top;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YtMusicApi$resolveWithClient$2(List<YtStream> list, Continuation<? super YtMusicApi$resolveWithClient$2> continuation) {
        super(2, continuation);
        this.$top = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        YtMusicApi$resolveWithClient$2 ytMusicApi$resolveWithClient$2 = new YtMusicApi$resolveWithClient$2(this.$top, continuation);
        ytMusicApi$resolveWithClient$2.L$0 = obj;
        return ytMusicApi$resolveWithClient$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super YtStream> continuation) {
        return ((YtMusicApi$resolveWithClient$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Deferred async$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                List<YtStream> list = this.$top;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new YtMusicApi$resolveWithClient$2$1$1((YtStream) it.next(), null), 3, null);
                    arrayList.add(async$default);
                }
                this.label = 1;
                Object awaitAll = AwaitKt.awaitAll(arrayList, this);
                if (awaitAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = awaitAll;
                break;
            case 1:
                obj2 = obj;
                ResultKt.throwOnFailure(obj2);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        for (Object obj3 : (Iterable) obj2) {
            if (((YtStream) obj3) != null) {
                return obj3;
            }
        }
        return null;
    }
}
