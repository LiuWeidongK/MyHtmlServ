/**
 * Created by Administrator on 2017/2/12.
 */
$(document).ready(function() {
    $('#updatePassForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            newPass: {
                validators: {
                    notEmpty: {
                        message: '此项不可为空'
                    },
                    regexp: {
                        regexp: /^[A-Za-z0-9]+$/,
                        message: '格式错误 密码只能包括字母和数字'
                    }
                }
            }
        }
    });
    $('#addModal').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            addLabNo: {
                validators: {
                    notEmpty: {
                        message: '此项不可为空'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9]+$/,
                        message: '此项不可包括特殊字符或汉字'
                    }
                }
            },
            addFacNo: {
                validators: {
                    notEmpty: {
                        message: '此项不可为空'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9]+$/,
                        message: '此项不可包括特殊字符或汉字'
                    }
                }
            },
            addFacName: {
                validators: {
                    notEmpty: {
                        message: '此项不可为空'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9\u4e00-\u9fa5]+$/,
                        message: '此项不可包括特殊字符'
                    }
                }
            },
            addFacMod: {
                validators: {
                    notEmpty: {
                        message: '此项不可为空'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9\u4e00-\u9fa5]+$/,
                        message: '此项不可包括特殊字符'
                    }
                }
            },
            addHaveNum: {
                validators: {
                    notEmpty: {
                        message: '此项不可为空'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: '此项只可为正整数'
                    }
                }
            },
            addDataInfo: {
                validators: {
                    notEmpty: {
                        message: '此项不可为空'
                    }
                }
            }
        }
    });
    $('#updateFacForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            upinputLabNo: {
                validators: {
                    notEmpty: {
                        message: '此项不可为空'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9]+$/,
                        message: '此项不可包括特殊字符或汉字'
                    }
                }
            },
            upinputFacName: {
                validators: {
                    notEmpty: {
                        message: '此项不可为空'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9\u4e00-\u9fa5]+$/,
                        message: '此项不可包括特殊字符'
                    }
                }
            },
            upinputFacMod: {
                validators: {
                    notEmpty: {
                        message: '此项不可为空'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9\u4e00-\u9fa5]+$/,
                        message: '此项不可包括特殊字符'
                    }
                }
            },
            upStock: {
                validators: {
                    notEmpty: {
                        message: '此项不可为空'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: '此项只可为正整数'
                    }
                }
            }
        }
    });
    $('#personalForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            collegeInput: {
                validators: {
                    regexp: {
                        regexp: /^[a-zA-Z\u4e00-\u9fa5]+$/,
                        message: '此项不可包括特殊字符'
                    }
                }
            },
            nameInput: {
                validators: {
                    regexp: {
                        regexp: /^[a-zA-Z\u4e00-\u9fa5]+$/,
                        message: '此项不可包括特殊字符'
                    }
                }
            },
            telInput: {
                validators: {
                    regexp: {
                        regexp: /^1[34578]\d{9}$/,
                        message: '请填写正确的电话号码格式'
                    }
                }
            }
        }
    });
    $('#borrowForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            UseDate: {
                validators: {
                    notEmpty: {
                        message: '此项不可为空'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: '此项只可为正整数'
                    }
                }
            }
        }
    });
});
