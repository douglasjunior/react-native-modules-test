//
//  MeuConsole.m
//  ReactNativeModulesTest
//
//  Created by Douglas Nassif Roma Junior on 12/04/17.
//  Copyright © 2017 Facebook. All rights reserved.
//

#import "MeuConsole.h"
#import <React/RCTLog.h>

@implementation MeuConsole

RCT_EXPORT_MODULE(MeuConsole);

RCT_EXPORT_METHOD(log:(NSString *)text) {
  RCTLogInfo(@"MEU_CONSOLE: %@", text);
}

RCT_EXPORT_METHOD(logObject:(NSDictionary *)object) {
  RCTLogInfo(@"MEU_CONSOLE: %@", object);
}

RCT_EXPORT_METHOD(logCallback:(NSString *)text
                  callError:(RCTResponseSenderBlock)callError
                  callSuccess:(RCTResponseSenderBlock)callSuccess) {
  if (text == nil) {
    NSDictionary * error = @{
                             @"code": @"100",
                             @"message": @"O parâmetro de texto não pode ser nulo."
                             };
    callError(@[error]);
    return;
  }
  
  RCTLogInfo(@"MEU_CONSOLE: %@", text);
  
  callSuccess(@[[NSNull null]]);
}

RCT_EXPORT_METHOD(logPromise:(NSString *)text
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject) {
  if (text == nil) {
    reject(@"100", @"O parâmetro de texto não pode ser nulo.", nil);
    return;
  }
  
  RCTLogInfo(@"MEU_CONSOLE: %@", text);
  
  resolve(nil);
}

@end

