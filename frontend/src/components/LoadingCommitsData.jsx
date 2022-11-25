

export default function LoadingCommitsData(Component){

    return function LoadingData({isLoading, ...props}){
         return (!isLoading) ? <Component {...props} />
         : <div>Data is loading</div>
    }
}
