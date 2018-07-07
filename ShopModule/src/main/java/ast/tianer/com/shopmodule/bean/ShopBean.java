package ast.tianer.com.shopmodule.bean;

import java.util.List;

/**
 * Created by ch on 2017/8/7 0007.
 */

public class ShopBean {
    /**
     * head : {"respCode":"0000000","respContent":"执行成功"}
     * body : {"designResults":[{"limit":"","offset":"","queryBeginDate":"","queryEndDate":"","pageNo":0,"pageSize":10,"pageCount":0,"recourdCount":"","id":"AB29BB6C729111E7A96B3497F625B277","productNo":"51cks20170727140557821","name":"我的设计1","category":"","bigCategory":"1","bigCategoryName":"","smallCategory":"4","smallCategoryName":"","intro":"12","price":0,"priceSection":"","isDeduction":"","maxDeductionPrice":"","detail":"12","searchNum":"","browseNum":"","isSale":1,"isFree":0,"userId":"002719A353CA426AAAB49C6237CC3727","userPhoto":"","createTime":1501135557000,"updateTime":1501145292000,"shelvesTime":"","deleteFlag":0,"images":"","file":"","userName":"aisite23434","subjectPic":"","imagePath":"","imageName":"","filePath":"","fileName":"","fileSize":"","subjectPicPath":"/uploadfiledata/2017/07/27/20170727_da7208b9-2157-4b79-9819-896346a128d0.png","subjectPicName":"","orderSort":"","salesVolume":"","likeNum":"","searchContent":"","saleVerify":"","verifyTime":1501145292000,"collectionNum":1,"recommended":1,"recommendedOrder":2,"isCanSale":1,"isCache":0,"oldId":"","printHour":1,"mainImage":"","files":""},{"limit":"","offset":"","queryBeginDate":"","queryEndDate":"","pageNo":0,"pageSize":10,"pageCount":0,"recourdCount":"","id":"F28257326C6111E7A96B3497F625B277","productNo":"51cks20170719170842334","name":"方块世界测试","category":"","bigCategory":"2CC8D6D9558D11E790D53497F625B277","bigCategoryName":"","smallCategory":"BA3DD36A613F11E790D53497F625B277","smallCategoryName":"","intro":"大大的 ","price":0,"priceSection":"","isDeduction":"","maxDeductionPrice":"","detail":"阿大声道阿达十大","searchNum":"","browseNum":"","isSale":1,"isFree":0,"userId":"002719A353CA426AAAB49C6237CC3727","userPhoto":"","createTime":1500455322000,"updateTime":1501145296000,"shelvesTime":"","deleteFlag":0,"images":"","file":"","userName":"aisite23434","subjectPic":"","imagePath":"","imageName":"","filePath":"","fileName":"","fileSize":"","subjectPicPath":"/uploadfiledata/2017/07/19/20170719_28962f20-af04-4162-b0be-b3d5e6f15a4e.jpg","subjectPicName":"","orderSort":"","salesVolume":"","likeNum":"","searchContent":"","saleVerify":"","verifyTime":1501145296000,"collectionNum":0,"recommended":1,"recommendedOrder":1,"isCanSale":1,"isCache":0,"oldId":"","printHour":1,"mainImage":"","files":""}],"banners":[{"limit":"","offset":"","queryBeginDate":"","queryEndDate":"","pageNo":0,"pageSize":10,"pageCount":0,"recourdCount":"","id":"1D7074DE525F11E790D53497F625B277","imageUrl":"/uploadfiledata/2017/08/07/20170807_c935981e-1603-41f2-889c-5a2479adcad1.png","linkUrl":"www.7k7k.com","linkStatus":"1","positionId":"5FC3D389523311E790D53497F625B277","orderNo":1,"status":"1","provinceId":"410000","province":"河南省","cityId":"411200","city":"三门峡市","showType":"1","createTime":"2017-06-16","updateTime":"2017-08-07","filePath1":"","fileName1":"","fileSuffix":"","locationName":"在线商城轮播图"}]}
     */

    private HeadBean head;
    private BodyBean body;

    public HeadBean getHead() {
        return head;
    }

    public void setHead(HeadBean head) {
        this.head = head;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class HeadBean {
        /**
         * respCode : 0000000
         * respContent : 执行成功
         */

        private String respCode;
        private String respContent;

        public String getRespCode() {
            return respCode;
        }

        public void setRespCode(String respCode) {
            this.respCode = respCode;
        }

        public String getRespContent() {
            return respContent;
        }

        public void setRespContent(String respContent) {
            this.respContent = respContent;
        }
    }

    public static class BodyBean {
        private List<DesignResultsBean> designResults;
        private List<BannersBean> banners;
        private String shoppingCarNum;

        public String getShoppingCarNum() {
            return shoppingCarNum;
        }

        public void setShoppingCarNum(String shoppingCarNum) {
            this.shoppingCarNum = shoppingCarNum;
        }

        public List<DesignResultsBean> getDesignResults() {
            return designResults;
        }

        public void setDesignResults(List<DesignResultsBean> designResults) {
            this.designResults = designResults;
        }

        public List<BannersBean> getBanners() {
            return banners;
        }

        public void setBanners(List<BannersBean> banners) {
            this.banners = banners;
        }

        public static class DesignResultsBean {
            /**
             * limit :
             * offset :
             * queryBeginDate :
             * queryEndDate :
             * pageNo : 0
             * pageSize : 10
             * pageCount : 0
             * recourdCount :
             * id : AB29BB6C729111E7A96B3497F625B277
             * productNo : 51cks20170727140557821
             * name : 我的设计1
             * category :
             * bigCategory : 1
             * bigCategoryName :
             * smallCategory : 4
             * smallCategoryName :
             * intro : 12
             * price : 0.0
             * priceSection :
             * isDeduction :
             * maxDeductionPrice :
             * detail : 12
             * searchNum :
             * browseNum :
             * isSale : 1
             * isFree : 0
             * userId : 002719A353CA426AAAB49C6237CC3727
             * userPhoto :
             * createTime : 1501135557000
             * updateTime : 1501145292000
             * shelvesTime :
             * deleteFlag : 0
             * images :
             * file :
             * userName : aisite23434
             * subjectPic :
             * imagePath :
             * imageName :
             * filePath :
             * fileName :
             * fileSize :
             * subjectPicPath : /uploadfiledata/2017/07/27/20170727_da7208b9-2157-4b79-9819-896346a128d0.png
             * subjectPicName :
             * orderSort :
             * salesVolume :
             * likeNum :
             * searchContent :
             * saleVerify :
             * verifyTime : 1501145292000
             * collectionNum : 1
             * recommended : 1
             * recommendedOrder : 2
             * isCanSale : 1
             * isCache : 0
             * oldId :
             * printHour : 1.0
             * mainImage :
             * files :
             */

            private String limit;
            private String offset;
            private String queryBeginDate;
            private String queryEndDate;
            private String pageNo;
            private String pageSize;
            private String pageCount;
            private String recourdCount;
            private String id;
            private String productNo;
            private String name;
            private String category;
            private String bigCategory;
            private String bigCategoryName;
            private String smallCategory;
            private String smallCategoryName;
            private String intro;
            private double price;
            private String priceSection;
            private String isDeduction;
            private String maxDeductionPrice;
            private String detail;
            private String searchNum;
            private String browseNum;
            private String isSale;
            private String isFree;
            private String userId;
            private String userPhoto;
            private String createTime;
            private String updateTime;
            private String shelvesTime;
            private String deleteFlag;
            private String images;
            private String file;
            private String userName;
            private String subjectPic;
            private String imagePath;
            private String imageName;
            private String filePath;
            private String fileName;
            private String fileSize;
            private String subjectPicPath;
            private String subjectPicName;
            private String orderSort;
            private String salesVolume;
            private String likeNum;
            private String searchContent;
            private String saleVerify;
            private String verifyTime;
            private String collectionNum;
            private String recommended;
            private String recommendedOrder;
            private String isCanSale;
            private String isCache;
            private String oldId;
            private String printHour;
            private String mainImage;
            private String files;


            public String getLimit() {
                return limit;
            }

            public void setLimit(String limit) {
                this.limit = limit;
            }

            public String getOffset() {
                return offset;
            }

            public void setOffset(String offset) {
                this.offset = offset;
            }

            public String getQueryBeginDate() {
                return queryBeginDate;
            }

            public void setQueryBeginDate(String queryBeginDate) {
                this.queryBeginDate = queryBeginDate;
            }

            public String getQueryEndDate() {
                return queryEndDate;
            }

            public void setQueryEndDate(String queryEndDate) {
                this.queryEndDate = queryEndDate;
            }

            public String getPageNo() {
                return pageNo;
            }

            public void setPageNo(String pageNo) {
                this.pageNo = pageNo;
            }

            public String getPageSize() {
                return pageSize;
            }

            public void setPageSize(String pageSize) {
                this.pageSize = pageSize;
            }

            public String getPageCount() {
                return pageCount;
            }

            public void setPageCount(String pageCount) {
                this.pageCount = pageCount;
            }

            public String getRecourdCount() {
                return recourdCount;
            }

            public void setRecourdCount(String recourdCount) {
                this.recourdCount = recourdCount;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getProductNo() {
                return productNo;
            }

            public void setProductNo(String productNo) {
                this.productNo = productNo;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getBigCategory() {
                return bigCategory;
            }

            public void setBigCategory(String bigCategory) {
                this.bigCategory = bigCategory;
            }

            public String getBigCategoryName() {
                return bigCategoryName;
            }

            public void setBigCategoryName(String bigCategoryName) {
                this.bigCategoryName = bigCategoryName;
            }

            public String getSmallCategory() {
                return smallCategory;
            }

            public void setSmallCategory(String smallCategory) {
                this.smallCategory = smallCategory;
            }

            public String getSmallCategoryName() {
                return smallCategoryName;
            }

            public void setSmallCategoryName(String smallCategoryName) {
                this.smallCategoryName = smallCategoryName;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getPriceSection() {
                return priceSection;
            }

            public void setPriceSection(String priceSection) {
                this.priceSection = priceSection;
            }

            public String getIsDeduction() {
                return isDeduction;
            }

            public void setIsDeduction(String isDeduction) {
                this.isDeduction = isDeduction;
            }

            public String getMaxDeductionPrice() {
                return maxDeductionPrice;
            }

            public void setMaxDeductionPrice(String maxDeductionPrice) {
                this.maxDeductionPrice = maxDeductionPrice;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public String getSearchNum() {
                return searchNum;
            }

            public void setSearchNum(String searchNum) {
                this.searchNum = searchNum;
            }

            public String getBrowseNum() {
                return browseNum;
            }

            public void setBrowseNum(String browseNum) {
                this.browseNum = browseNum;
            }

            public String getIsSale() {
                return isSale;
            }

            public void setIsSale(String isSale) {
                this.isSale = isSale;
            }

            public String getIsFree() {
                return isFree;
            }

            public void setIsFree(String isFree) {
                this.isFree = isFree;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getUserPhoto() {
                return userPhoto;
            }

            public void setUserPhoto(String userPhoto) {
                this.userPhoto = userPhoto;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getShelvesTime() {
                return shelvesTime;
            }

            public void setShelvesTime(String shelvesTime) {
                this.shelvesTime = shelvesTime;
            }

            public String getDeleteFlag() {
                return deleteFlag;
            }

            public void setDeleteFlag(String deleteFlag) {
                this.deleteFlag = deleteFlag;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public String getFile() {
                return file;
            }

            public void setFile(String file) {
                this.file = file;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getSubjectPic() {
                return subjectPic;
            }

            public void setSubjectPic(String subjectPic) {
                this.subjectPic = subjectPic;
            }

            public String getImagePath() {
                return imagePath;
            }

            public void setImagePath(String imagePath) {
                this.imagePath = imagePath;
            }

            public String getImageName() {
                return imageName;
            }

            public void setImageName(String imageName) {
                this.imageName = imageName;
            }

            public String getFilePath() {
                return filePath;
            }

            public void setFilePath(String filePath) {
                this.filePath = filePath;
            }

            public String getFileName() {
                return fileName;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }

            public String getFileSize() {
                return fileSize;
            }

            public void setFileSize(String fileSize) {
                this.fileSize = fileSize;
            }

            public String getSubjectPicPath() {
                return subjectPicPath;
            }

            public void setSubjectPicPath(String subjectPicPath) {
                this.subjectPicPath = subjectPicPath;
            }

            public String getSubjectPicName() {
                return subjectPicName;
            }

            public void setSubjectPicName(String subjectPicName) {
                this.subjectPicName = subjectPicName;
            }

            public String getOrderSort() {
                return orderSort;
            }

            public void setOrderSort(String orderSort) {
                this.orderSort = orderSort;
            }

            public String getSalesVolume() {
                return salesVolume;
            }

            public void setSalesVolume(String salesVolume) {
                this.salesVolume = salesVolume;
            }

            public String getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(String likeNum) {
                this.likeNum = likeNum;
            }

            public String getSearchContent() {
                return searchContent;
            }

            public void setSearchContent(String searchContent) {
                this.searchContent = searchContent;
            }

            public String getSaleVerify() {
                return saleVerify;
            }

            public void setSaleVerify(String saleVerify) {
                this.saleVerify = saleVerify;
            }

            public String getVerifyTime() {
                return verifyTime;
            }

            public void setVerifyTime(String verifyTime) {
                this.verifyTime = verifyTime;
            }

            public String getCollectionNum() {
                return collectionNum;
            }

            public void setCollectionNum(String collectionNum) {
                this.collectionNum = collectionNum;
            }

            public String getRecommended() {
                return recommended;
            }

            public void setRecommended(String recommended) {
                this.recommended = recommended;
            }

            public String getRecommendedOrder() {
                return recommendedOrder;
            }

            public void setRecommendedOrder(String recommendedOrder) {
                this.recommendedOrder = recommendedOrder;
            }

            public String getIsCanSale() {
                return isCanSale;
            }

            public void setIsCanSale(String isCanSale) {
                this.isCanSale = isCanSale;
            }

            public String getIsCache() {
                return isCache;
            }

            public void setIsCache(String isCache) {
                this.isCache = isCache;
            }

            public String getOldId() {
                return oldId;
            }

            public void setOldId(String oldId) {
                this.oldId = oldId;
            }

            public String getPrintHour() {
                return printHour;
            }

            public void setPrintHour(String printHour) {
                this.printHour = printHour;
            }

            public String getMainImage() {
                return mainImage;
            }

            public void setMainImage(String mainImage) {
                this.mainImage = mainImage;
            }

            public String getFiles() {
                return files;
            }

            public void setFiles(String files) {
                this.files = files;
            }
        }

        public static class BannersBean {
            /**
             * limit :
             * offset :
             * queryBeginDate :
             * queryEndDate :
             * pageNo : 0
             * pageSize : 10
             * pageCount : 0
             * recourdCount :
             * id : 1D7074DE525F11E790D53497F625B277
             * imageUrl : /uploadfiledata/2017/08/07/20170807_c935981e-1603-41f2-889c-5a2479adcad1.png
             * linkUrl : www.7k7k.com
             * linkStatus : 1
             * positionId : 5FC3D389523311E790D53497F625B277
             * orderNo : 1
             * status : 1
             * provinceId : 410000
             * province : 河南省
             * cityId : 411200
             * city : 三门峡市
             * showType : 1
             * createTime : 2017-06-16
             * updateTime : 2017-08-07
             * filePath1 :
             * fileName1 :
             * fileSuffix :
             * locationName : 在线商城轮播图
             */

            private String limit;
            private String offset;
            private String queryBeginDate;
            private String queryEndDate;
            private String pageNo;
            private String pageSize;
            private String pageCount;
            private String recourdCount;
            private String id;
            private String imageUrl;
            private String linkUrl;
            private String linkStatus;
            private String positionId;
            private String orderNo;
            private String status;
            private String provinceId;
            private String province;
            private String cityId;
            private String city;
            private String showType;
            private String createTime;
            private String updateTime;
            private String filePath1;
            private String fileName1;
            private String fileSuffix;
            private String locationName;

            public String getLimit() {
                return limit;
            }

            public void setLimit(String limit) {
                this.limit = limit;
            }

            public String getOffset() {
                return offset;
            }

            public void setOffset(String offset) {
                this.offset = offset;
            }

            public String getQueryBeginDate() {
                return queryBeginDate;
            }

            public void setQueryBeginDate(String queryBeginDate) {
                this.queryBeginDate = queryBeginDate;
            }

            public String getQueryEndDate() {
                return queryEndDate;
            }

            public void setQueryEndDate(String queryEndDate) {
                this.queryEndDate = queryEndDate;
            }

            public String getPageNo() {
                return pageNo;
            }

            public void setPageNo(String pageNo) {
                this.pageNo = pageNo;
            }

            public String getPageSize() {
                return pageSize;
            }

            public void setPageSize(String pageSize) {
                this.pageSize = pageSize;
            }

            public String getPageCount() {
                return pageCount;
            }

            public void setPageCount(String pageCount) {
                this.pageCount = pageCount;
            }

            public String getRecourdCount() {
                return recourdCount;
            }

            public void setRecourdCount(String recourdCount) {
                this.recourdCount = recourdCount;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getLinkUrl() {
                return linkUrl;
            }

            public void setLinkUrl(String linkUrl) {
                this.linkUrl = linkUrl;
            }

            public String getLinkStatus() {
                return linkStatus;
            }

            public void setLinkStatus(String linkStatus) {
                this.linkStatus = linkStatus;
            }

            public String getPositionId() {
                return positionId;
            }

            public void setPositionId(String positionId) {
                this.positionId = positionId;
            }

            public String getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(String orderNo) {
                this.orderNo = orderNo;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getProvinceId() {
                return provinceId;
            }

            public void setProvinceId(String provinceId) {
                this.provinceId = provinceId;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getShowType() {
                return showType;
            }

            public void setShowType(String showType) {
                this.showType = showType;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getFilePath1() {
                return filePath1;
            }

            public void setFilePath1(String filePath1) {
                this.filePath1 = filePath1;
            }

            public String getFileName1() {
                return fileName1;
            }

            public void setFileName1(String fileName1) {
                this.fileName1 = fileName1;
            }

            public String getFileSuffix() {
                return fileSuffix;
            }

            public void setFileSuffix(String fileSuffix) {
                this.fileSuffix = fileSuffix;
            }

            public String getLocationName() {
                return locationName;
            }

            public void setLocationName(String locationName) {
                this.locationName = locationName;
            }
        }
    }
}
