package SumServer;

import com.proto.sum.*;
import io.grpc.stub.StreamObserver;

public class SumServerImpl extends SumServiceGrpc.SumServiceImplBase{
    @Override
    public void sum(SumRequest request, StreamObserver<SumResponse> responseObserver){
        Sum sum = request.getSum();
        String firstNum = sum.getFirstNum();
        String lastNum = sum.getLastNum();

        Integer result = Integer.parseInt(firstNum) + Integer.parseInt(lastNum);
        SumResponse response = SumResponse.newBuilder()
                .setResult(result)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
